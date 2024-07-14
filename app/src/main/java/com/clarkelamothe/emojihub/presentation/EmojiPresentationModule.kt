package com.clarkelamothe.emojihub.presentation

import com.clarkelamothe.emojihub.presentation.emojis.EmojiViewmodel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val emojiPresentationModule = module {

    viewModelOf(::EmojiViewmodel)
}
