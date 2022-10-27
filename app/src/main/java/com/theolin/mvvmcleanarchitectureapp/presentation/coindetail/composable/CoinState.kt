package com.theolin.mvvmcleanarchitectureapp.presentation.coindetail.composable

import com.theolin.mvvmcleanarchitectureapp.domain.model.CoinDetail

data class CoinState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error:String = ""
)