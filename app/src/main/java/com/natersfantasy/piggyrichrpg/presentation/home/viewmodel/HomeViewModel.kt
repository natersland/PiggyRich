package com.natersfantasy.piggyrichrpg.presentation.home.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.natersfantasy.piggyrichrpg.data.user.User
import com.natersfantasy.piggyrichrpg.data.user.UserRepository
import com.natersfantasy.piggyrichrpg.ui.theme.PiggyRichColor
import com.natersfantasy.piggyrichrpg.util.Routes
import com.natersfantasy.piggyrichrpg.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.natersfantasy.piggyrichrpg.R
import com.natersfantasy.piggyrichrpg.data.game.Level
import com.natersfantasy.piggyrichrpg.data.game.levelList
import com.natersfantasy.piggyrichrpg.presentation.home.HomeScreenViewAction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    var user by mutableStateOf<User?>(null)
        private set

    var userBgColor by mutableStateOf(PiggyRichColor.Chicken)
        private set

    var userMascot by mutableStateOf(R.drawable.char_chicken)
        private set

    var currentChallenge by mutableStateOf<Level?>(null)
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        getUser(1)
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.OnHandleColorBgLevel -> {
                val result = handleBgColorLevel(user?.level)
                userBgColor = result
            }
            is HomeEvent.OnHandleMascotLevel -> {
                val result = handleMascotLevel(user?.level)
                userMascot = result
            }
            is HomeEvent.OnHandleCurrentLevel -> {
                val result = user?.level?.let { handleCurrentChallenge(it) }
                currentChallenge = result
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
    
    private fun handleBgColorLevel(level: Int?): androidx.compose.ui.graphics.Color {
        return when (level) {
            1 -> PiggyRichColor.Chicken
            2 -> PiggyRichColor.Giraffe
            3 -> PiggyRichColor.Lobster
            4 -> PiggyRichColor.Frog
            5 -> PiggyRichColor.Dolphin
            6 -> PiggyRichColor.Cat
            else -> {
                PiggyRichColor.Chicken
            }
        }
    }

    private fun handleMascotLevel(level: Int?): Int {
        return when (level) {
            1 -> R.drawable.char_chicken
            2 -> R.drawable.char_giraffe
            3 -> R.drawable.char_lobster
            4 -> R.drawable.char_frog
            5 -> R.drawable.char_dolphin
            6 -> R.drawable.char_cat
            else -> {
                R.drawable.char_chicken
            }
        }
    }

    private fun handleCurrentChallenge(level: Int): Level {
        return Level(
            level = levelList[level - 1].level,
            savingGoal = levelList[level - 1].savingGoal,
            mascotName = levelList[level - 1].mascotName,
            mascotImage = levelList[level - 1].mascotImage,
            levelColor = levelList[level - 1].levelColor
        )
    }

    private fun getUser(userId: Int) {
        viewModelScope.launch {
            repository.getCurrentUser(userId)
                ?.flowOn(Dispatchers.IO)
                ?.catch {
                    println("Failed to fetch user data ja")
                }
                ?.collect { userData ->
                    user = userData
                }
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}