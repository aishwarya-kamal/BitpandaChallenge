package com.test.bitpandachallenge.data.remote

import com.test.bitpandachallenge.data.remote.DummyData.Companion.cryptocoins
import com.test.bitpandachallenge.data.remote.DummyData.Companion.dummyCryptoWalletList
import com.test.bitpandachallenge.data.remote.DummyData.Companion.dummyEURWallet
import com.test.bitpandachallenge.data.remote.DummyData.Companion.dummyMetalWalletList
import com.test.bitpandachallenge.data.remote.DummyData.Companion.fiats
import com.test.bitpandachallenge.data.remote.DummyData.Companion.metals
import com.test.bitpandachallenge.model.*

class DummyWebService {

    fun getCryptoWallets(): List<CryptocoinWallet> = dummyCryptoWalletList

    fun getMetalWallets(): List<MetalWallet> = dummyMetalWalletList

    fun getFiatWallets(): List<FiatWallet> = dummyEURWallet

    fun getCryptocoins(): List<Cryptocoin> = cryptocoins

    fun getMetals(): List<Metal> = metals

    fun getFiats(): List<Fiat> = fiats

    fun getCurrencies(): List<Currency> = listOf( fiats, cryptocoins, metals)
        .flatten()

}