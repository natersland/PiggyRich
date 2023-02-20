package com.natersfantasy.piggyrichrpg.presentation.splashscreen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.natersfantasy.piggyrichrpg.presentation.splashscreen.viewmodel.SplashScreenEvent
import com.natersfantasy.piggyrichrpg.util.Routes
import com.natersfantasy.piggyrichrpg.util.UiEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashScreenViewModel @Inject constructor():ViewModel() {
    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: SplashScreenEvent) {
        when(event) {
            is SplashScreenEvent.OnSplashScreenRun -> {
                sendUiEvent(UiEvent.PopBackStack)
                sendUiEvent(UiEvent.Navigate(Routes.NEW_MEMBER))
            }
        }
    }
    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

}