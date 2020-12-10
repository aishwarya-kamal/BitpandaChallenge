package com.test.bitpandachallenge.di

import com.test.bitpandachallenge.di.listofwallets.ListOfWalletsViewModelModule
import com.test.bitpandachallenge.di.walletdetails.WalletDetailsViewModelModule
import com.test.bitpandachallenge.ui.listofwallets.ListOfWalletsFragment
import com.test.bitpandachallenge.ui.walletdetails.WalletDetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector(modules = [ListOfWalletsViewModelModule::class])
    abstract fun contributeListOfWalletsFragment() : ListOfWalletsFragment

    @ContributesAndroidInjector(modules = [WalletDetailsViewModelModule::class])
    abstract fun contributeWalletDetailsFragment() : WalletDetailsFragment

}