package com.theolin.mvvmcleanarchitectureapp.data.remote.dto.repository

import com.theolin.mvvmcleanarchitectureapp.data.remote.dto.CoinDetailDto
import com.theolin.mvvmcleanarchitectureapp.data.remote.dto.CoinDto
import com.theolin.mvvmcleanarchitectureapp.data.remote.dto.CoinPaprikaApi
import com.theolin.mvvmcleanarchitectureapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api :CoinPaprikaApi) :CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}