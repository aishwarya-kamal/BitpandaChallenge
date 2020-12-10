package com.test.bitpandachallenge.data.local

import android.os.Parcelable
import com.test.bitpandachallenge.data.remote.DummyWebService
import com.test.bitpandachallenge.model.CryptocoinWallet
import com.test.bitpandachallenge.model.FiatWallet
import com.test.bitpandachallenge.model.MetalWallet
import com.test.bitpandachallenge.model.Wallet
import kotlinx.android.parcel.Parcelize

fun List<Wallet>.asDomainModel(webservice: DummyWebService): List<DomainModel> {
    var icon: String? = null
    var symbol: String? = null
    var metalName: String? = ""
    var price: Double? = null
    var precision: Int? = null

    return map { wallet ->

        when (wallet) {
            is CryptocoinWallet -> {
                icon = webservice.getCryptocoins().first { wallet.cryptocoinId == it.id }.logo
                symbol = webservice.getCryptocoins().first { wallet.cryptocoinId == it.id }.symbol
                price = webservice.getCryptocoins().first { wallet.cryptocoinId == it.id }.price
                precision =
                    webservice.getCryptocoins().first { wallet.cryptocoinId == it.id }.precision
                metalName = ""
            }
            is MetalWallet -> {
                icon = webservice.getMetals().first { wallet.metalId == it.id }.logo
                symbol = webservice.getMetals().first { wallet.metalId == it.id }.symbol
                metalName = webservice.getMetals().first { wallet.metalId == it.id }.name
                price = webservice.getMetals().first { wallet.metalId == it.id }.price
                precision = webservice.getMetals().first { wallet.metalId == it.id }.precision
            }
            is FiatWallet -> {
                icon = webservice.getFiats().first { wallet.fiatId == it.id }.logo
                symbol = webservice.getFiats().first { wallet.fiatId == it.id }.symbol
                precision = webservice.getFiats().first { wallet.fiatId == it.id }.precision
                price = 0.00
                metalName = ""
            }
        }

        DomainModel(icon, symbol, wallet.balance, metalName, price, precision)
    }
}

@Parcelize
data class DomainModel(
    val icon: String? /*logofromcurrency*/,
    val symbol: String? /*symbolfromcurrency*/,
    val balance: Double? /*balancefromWallet*/,
    val metalName: String? = ""/*namefromcurrency*/,
    val price: Double? /*pricefromcurrency*/,
    val precision: Int? /*precisionfromcurrency*/
) : Parcelable