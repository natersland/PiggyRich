package com.natersfantasy.piggyrichrpg.presentation.home.viewmodel

import java.util.Objects

sealed class HomeEvent {
    object OnHandleColorBgLevel : HomeEvent()
    object OnHandleMascotLevel: HomeEvent()
    object OnChallengeClick : HomeEvent()
    object OnBadgeClick : HomeEvent()
    object OnSettingClick : HomeEvent()

}