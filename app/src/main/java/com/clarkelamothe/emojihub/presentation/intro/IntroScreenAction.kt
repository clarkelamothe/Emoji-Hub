package com.clarkelamothe.emojihub.presentation.intro

sealed interface IntroScreenAction {
    data object OnShowEmojiClick : IntroScreenAction
}
