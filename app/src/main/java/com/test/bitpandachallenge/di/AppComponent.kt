package com.test.bitpandachallenge.di

import android.content.Context
import com.test.bitpandachallenge.MainApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        FragmentBuilderModule::class,
        ViewModelFactoryModule::class,
        AppModule::class]
)
interface AppComponent : AndroidInjector<MainApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }
}