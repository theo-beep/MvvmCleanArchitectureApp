package com.theolin.mvvmcleanarchitectureapp.di

import com.theolin.mvvmcleanarchitectureapp.common.Constants
import com.theolin.mvvmcleanarchitectureapp.data.remote.dto.CoinPaprikaApi
import com.theolin.mvvmcleanarchitectureapp.data.remote.dto.repository.CoinRepositoryImpl
import com.theolin.mvvmcleanarchitectureapp.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api : CoinPaprikaApi) : CoinRepository {
        return CoinRepositoryImpl(api = api)
    }


}