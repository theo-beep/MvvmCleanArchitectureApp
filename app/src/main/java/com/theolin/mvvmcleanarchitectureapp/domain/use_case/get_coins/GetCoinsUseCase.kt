package com.theolin.mvvmcleanarchitectureapp.domain.use_case.get_coins

import com.theolin.mvvmcleanarchitectureapp.common.Resource
import com.theolin.mvvmcleanarchitectureapp.data.remote.dto.toCoin
import com.theolin.mvvmcleanarchitectureapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke() = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "an unexpected error occurred "))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server . check your internet connection "))
        }
    }
}