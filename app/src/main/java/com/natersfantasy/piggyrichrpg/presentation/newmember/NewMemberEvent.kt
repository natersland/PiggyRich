package com.natersfantasy.piggyrichrpg.presentation.newmember

sealed class NewMemberEvent {
    data class OnUserNameChange(val name: String) : NewMemberEvent()
    object OnStartClick : NewMemberEvent()
    object OnRandomClick : NewMemberEvent()
}