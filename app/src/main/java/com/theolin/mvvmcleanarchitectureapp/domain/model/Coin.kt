package com.theolin.mvvmcleanarchitectureapp.domain.model

data class Coin(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    var symbol: String,
)

