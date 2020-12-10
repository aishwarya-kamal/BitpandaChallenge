package com.test.bitpandachallenge.di

import android.content.Context
import com.test.bitpandachallenge.data.remote.DummyWebService
import com.test.bitpandachallenge.repository.DefaultRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
object AppModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideWebService(): DummyWebService {
        return DummyWebService()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideRepository(
        service: DummyWebService
    ): DefaultRepository {
        return DefaultRepository(
            webService = service
        )
    }

}