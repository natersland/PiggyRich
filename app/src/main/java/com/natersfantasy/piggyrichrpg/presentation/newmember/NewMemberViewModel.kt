package com.natersfantasy.piggyrichrpg.presentation.newmember

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.natersfantasy.piggyrichrpg.data.user.User
import com.natersfantasy.piggyrichrpg.data.user.UserRepository
import com.natersfantasy.piggyrichrpg.data.username.Name
import com.natersfantasy.piggyrichrpg.data.username.nameList
import com.natersfantasy.piggyrichrpg.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.natersfantasy.piggyrichrpg.ui.theme.userDisplayLanguage
import com.natersfantasy.piggyrichrpg.util.Routes
import kotlin.random.Random


@HiltViewModel
class NewMemberViewModel @Inject constructor(
    private val repository: UserRepository,
): ViewModel() {

    var user by mutableStateOf<User?>(null)
        private set

    var userName by mutableStateOf("")
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()
    
    fun onEvent(event: NewMemberEvent) {
        when(event) {
            is NewMemberEvent.OnUserNameChange -> {
                userName = event.name
            }
            is NewMemberEvent.OnStartClick -> {
                viewModelScope.launch {
                    if (userName.isBlank()) {
                        sendUiEvent(UiEvent.ShowSnackbar(
                            message = when(userDisplayLanguage.language) {
                                "th" -> "กรุณาใส่ชื่อ"
                                else -> "Please enter your name."
                            }
                        ))
                        return@launch
                    }
                    repository.addUser(
                        User(
                            name = userName,
                            level = 1,
                            savingMoney = 0
                        )
                    )
                    sendUiEvent(UiEvent.PopBackStack)
                    if (userName.isNotBlank()) {
                        sendUiEvent(UiEvent.Navigate(Routes.HOME))
                    }
                }
            }
            is NewMemberEvent.OnRandomClick -> {
                val result = generateRandomName(nameList = nameList)
                userName = result
            }
        }
    }
    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch { 
            _uiEvent.send(event)
        }
    }
    private fun generateRandomName(nameList: List<Name>): String {
        val random = Random.Default
        val randomIndex = random.nextInt(nameList.size)
        return when (userDisplayLanguage.language) {
            "th" -> nameList[randomIndex].thaiName
            else -> nameList[randomIndex].engName
        }
    }

}