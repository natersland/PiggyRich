package com.natersfantasy.piggyrichrpg.presentation.splashscreen.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.natersfantasy.piggyrichrpg.data.user.User
import com.natersfantasy.piggyrichrpg.data.user.UserRepository
import com.natersfantasy.piggyrichrpg.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.natersfantasy.piggyrichrpg.util.Routes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import java.util.*
import java.util.logging.Handler

@HiltViewModel
class SplashScreenViewModel @Inject constructor(private val repository: UserRepository) :
    ViewModel() {
    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    var users by mutableStateOf<List<User?>>(emptyList())
        private set

    init {
        sendUiEvent(UiEvent.PopBackStack)
        checkIsHaveAnAccount()
    }

    private fun checkIsHaveAnAccount() {
        viewModelScope.launch {
            repository.getAllUsers()
                .flowOn(Dispatchers.IO)
                .catch {
                    println("Error to fetch users data jaaa")
                }
                .collect { usersList ->
                    users = usersList

                    Timer().schedule(object: TimerTask() {
                        override fun run() {
                            if (users.isNotEmpty()) {
                                sendUiEvent(UiEvent.Navigate(Routes.HOME))
                            } else {
                                sendUiEvent(UiEvent.Navigate(Routes.NEW_MEMBER))
                            }
                        }
                    }, 3000)
                }
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

}