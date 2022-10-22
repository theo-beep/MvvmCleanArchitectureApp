package com.theolin.mvvmcleanarchitectureapp.domain.use_case.get_coin

import com.theolin.mvvmcleanarchitectureapp.common.Resource
import com.theolin.mvvmcleanarchitectureapp.data.remote.dto.toCoin
import com.theolin.mvvmcleanarchitectureapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinByIdUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(coindId : String ) = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coindId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "an unexpected error occurred "))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server . check your internet connection "))
        }
    }
}