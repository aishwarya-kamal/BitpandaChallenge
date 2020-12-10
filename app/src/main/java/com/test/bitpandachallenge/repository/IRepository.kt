package com.test.bitpandachallenge.repository

import com.test.bitpandachallenge.model.Wallet

interface IRepository {
    fun getCurrencyWallets(filterCurrencyWalletBy: String): List<Wallet>
}