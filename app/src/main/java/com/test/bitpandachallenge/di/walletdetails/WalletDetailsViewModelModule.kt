package com.test.bitpandachallenge.di.walletdetails

import androidx.lifecycle.ViewModel
import com.test.bitpandachallenge.di.ViewModelKey
import com.test.bitpandachallenge.ui.walletdetails.WalletDetailsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class WalletDetailsViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(WalletDetailsViewModel::class)
    abstract fun bindWalletDetailsViewModel(walletDetailsViewModel: WalletDetailsViewModel): ViewModel
}