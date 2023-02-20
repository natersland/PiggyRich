package com.natersfantasy.piggyrichrpg.presentation.home.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.natersfantasy.piggyrichrpg.data.user.User
import com.natersfantasy.piggyrichrpg.data.user.UserRepository
import com.natersfantasy.piggyrichrpg.util.Routes
import com.natersfantasy.piggyrichrpg.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val repository: UserRepository
): ViewModel() {

    var user by mutableStateOf<User?>(null)
        private set

    var userName by mutableStateOf("")
        private set

    var userLevel by mutableStateOf(0)

    var savingAmount by mutableStateOf(0)
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: HomeEvent) {
        when(event) {
            is HomeEvent.OnGetUserName -> {
                userName = event.name
            }
            is HomeEvent.OnGetUserLevel -> {
                userLevel = event.level
            }
            is HomeEvent.OnSavingAmountChange -> {
                savingAmount = event.money
            }
            is HomeEvent.OnBadgeClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.BADGE))
            }
            is HomeEvent.OnChallengeClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.CHALLENGE))
            }
            is HomeEvent.OnSettingClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.SETTING))
            }
        }
    }
    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}