package com.theolin.mvvmcleanarchitectureapp.domain.model

import com.theolin.mvvmcleanarchitectureapp.data.remote.dto.CoinDetailDto

data class CoinDetail (
    val coinId :String,
    val name :String ,
    val description:String,
    val symbol:String ,
    val rank:Int,
    val isActivive :Boolean,
    val tags :List<CoinDetailDto.Tag>,
    val team : List<CoinDetailDto.TeamMember>,
    val typeval :String ,
    val whitepaper: CoinDetailDto.Whitepaper
)