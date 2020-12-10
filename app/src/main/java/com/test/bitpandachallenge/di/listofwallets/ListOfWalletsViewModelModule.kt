package com.test.bitpandachallenge.di.listofwallets

import androidx.lifecycle.ViewModel
import com.test.bitpandachallenge.di.ViewModelKey
import com.test.bitpandachallenge.ui.listofwallets.ListOfWalletsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ListOfWalletsViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListOfWalletsViewModel::class)
    abstract fun bindListOfWalletsViewModel(listOfWalletsViewModel: ListOfWalletsViewModel): ViewModel
}