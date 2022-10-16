package com.theolin.mvvmcleanarchitectureapp.data.remote.dto


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.theolin.mvvmcleanarchitectureapp.domain.model.Coin

@Keep
data class CoinDto(
    @SerializedName("id") var id: String,
    @SerializedName("is_active") var isActive: Boolean,
    @SerializedName("is_new") var isNew: Boolean,
    @SerializedName("name") var name: String,
    @SerializedName("rank") var rank: Int,
    @SerializedName("symbol") var symbol: String,
    @SerializedName("type") var type: String
)

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}