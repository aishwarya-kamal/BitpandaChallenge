package com.test.bitpandachallenge.repository

import com.test.bitpandachallenge.data.local.DomainModel
import com.test.bitpandachallenge.data.local.asDomainModel
import com.test.bitpandachallenge.data.remote.DummyWebService
import com.test.bitpandachallenge.model.CryptocoinWallet
import com.test.bitpandachallenge.model.FiatWallet
import com.test.bitpandachallenge.model.MetalWallet
import com.test.bitpandachallenge.model.Wallet
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultRepository @Inject constructor(
    val webService: DummyWebService
) : IRepository {

    override fun getCurrencyWallets(
        filterCurrencyWalletBy: String
    ): List<Wallet> {

        val listOfWallets = listOf(
            webService.getFiatWallets(),
            webService.getCryptoWallets(),
            webService.getMetalWallets()
        ).flatten()
            .filterNot { it.deleted }
            .filter {
                when (filterCurrencyWalletBy) {
                    "fiat" -> it is FiatWallet
                    "crypto" -> it is CryptocoinWallet
                    "metal" -> it is MetalWallet
                    else -> true
                }
            }
        return if (filterCurrencyWalletBy.equals("balance")){
            listOfWallets.sortedBy { it.balance }
        } else {
            listOfWallets
        }
    }

    fun getCurrency(filterCurrencyWalletBy: String): List<DomainModel> {
        return getCurrencyWallets(filterCurrencyWalletBy).asDomainModel(webService)
    }
}