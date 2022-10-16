package com.theolin.mvvmcleanarchitectureapp.domain.repository

import com.theolin.mvvmcleanarchitectureapp.data.remote.dto.CoinDetailDto
import com.theolin.mvvmcleanarchitectureapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins() : List<CoinDto>

    suspend fun getCoinById(coinId : String) : CoinDetailDto

}