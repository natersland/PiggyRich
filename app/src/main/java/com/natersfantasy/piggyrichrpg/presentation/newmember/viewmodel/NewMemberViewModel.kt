package com.natersfantasy.piggyrichrpg.presentation.newmember.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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
import com.natersfantasy.piggyrichrpg.commons.usecases.levelHandling
import kotlin.random.Random


@HiltViewModel
class NewMemberViewModel @Inject constructor(
    private val repository: UserRepository,
) : ViewModel() {
    var users = repository.getAllUsers()

    var user by mutableStateOf<User?>(null)
        private set

    var userName by mutableStateOf("")
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
    }

    fun onEvent(event: NewMemberEvent) {
        when (event) {
            is NewMemberEvent.OnUserNameChange -> {
                userName = event.name
            }
            is NewMemberEvent.OnStartClick -> {
                viewModelScope.launch {
                    if (userName.isBlank()) {
                        // TODO แก้เป็น ShowToast
                        sendUiEvent(
                            UiEvent.ShowSnackbar(
                                message = when (userDisplayLanguage.language) {
                                    "th" -> "กรุณาใส่ชื่อ"
                                    else -> "Please enter your name."
                                }
                            )
                        )
                        return@launch
                    }
                    val randomMoney = Random.nextInt(100000)

                    repository.addUser(
                        User(
                            name = userName,
                            level = levelHandling(randomMoney),
                            savingMoney = randomMoney,
                            id = user?.id
                        )
                    )

                    sendUiEvent(UiEvent.PopBackStack)
                    sendUiEvent(UiEvent.Navigate(Routes.HOME))
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

    private fun generateRandomName(nameList: List<Name>): String {
        val random = Random.Default
        val randomIndex = random.nextInt(nameList.size)
        return when (userDisplayLanguage.language) {
            "th" -> nameList[randomIndex].thaiName
            else -> nameList[randomIndex].engName
        }
    }



    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

}