package com.natersfantasy.piggyrichrpg.presentation.home.viewmodel

sealed class HomeEvent {
    data class OnSavingAmountChange(val money: Int) : HomeEvent()
    object OnChallengeClick : HomeEvent()
    object OnBadgeClick : HomeEvent()
    object OnSettingClick : HomeEvent()
}