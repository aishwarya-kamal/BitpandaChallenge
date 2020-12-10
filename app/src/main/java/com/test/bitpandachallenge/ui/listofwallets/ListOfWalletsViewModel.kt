package com.test.bitpandachallenge.ui.listofwallets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.test.bitpandachallenge.repository.DefaultRepository
import javax.inject.Inject

class ListOfWalletsViewModel @Inject constructor(
    private val repository: DefaultRepository
) : ViewModel() {

    fun wallets(filterCurrencyWalletBy: String) = liveData {
        emit(repository.getCurrency(filterCurrencyWalletBy))
    }

}