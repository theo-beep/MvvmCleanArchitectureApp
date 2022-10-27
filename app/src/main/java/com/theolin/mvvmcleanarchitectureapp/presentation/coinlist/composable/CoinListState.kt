package com.theolin.mvvmcleanarchitectureapp.presentation.coinlist.composable

import com.theolin.mvvmcleanarchitectureapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false ,
    val coins : List<Coin> = emptyList(),
    val error :String = ""
)