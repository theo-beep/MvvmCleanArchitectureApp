package com.theolin.mvvmcleanarchitectureapp.presentation.coindetail.composable

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.theolin.mvvmcleanarchitectureapp.common.Constants
import com.theolin.mvvmcleanarchitectureapp.common.Resource
import com.theolin.mvvmcleanarchitectureapp.domain.use_case.get_coin.GetCoinByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor(
    private val getCoinByIdUseCase: GetCoinByIdUseCase ,
    private val savedStateHandle: SavedStateHandle) :
    ViewModel() {

    private val _state = mutableStateOf(CoinState())
    val state : State<CoinState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let{ coinId -> getCoin(coinId) }
    }

    private fun  getCoin(coinId : String){
        getCoinByIdUseCase(coinId).onEach { result ->
            when(result){
                is Resource.Success ->{
                    _state.value = CoinState(coin= result.data)
                }
                is Resource.Error ->{
                    _state.value = CoinState(
                        error = result.message ?:
                    "an unexpected error occured ")
                }
                is Resource.Loading -> {
                    _state.value = CoinState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }


}