package com.theolin.mvvmcleanarchitectureapp.data.remote.dto

import retrofit2.http.GET

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins()
}