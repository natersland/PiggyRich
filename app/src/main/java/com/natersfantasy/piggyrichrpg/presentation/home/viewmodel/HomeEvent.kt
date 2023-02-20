package com.natersfantasy.piggyrichrpg.presentation.home.viewmodel

sealed class HomeEvent {
    data class OnGetUserName(val name: String) : HomeEvent()
    data class OnGetUserLevel(val level: Int) : HomeEvent()
    object OnHandleColorBgLevel : HomeEvent()
    object OnHandleMascotLevel: HomeEvent()
    data class OnSavingAmountChange(val money: Int) : HomeEvent()
    object OnChallengeClick : HomeEvent()
    object OnBadgeClick : HomeEvent()
    object OnSettingClick : HomeEvent()

}