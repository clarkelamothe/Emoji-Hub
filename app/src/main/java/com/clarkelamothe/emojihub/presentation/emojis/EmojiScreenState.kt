package com.clarkelamothe.emojihub.presentation.emojis

import com.clarkelamothe.emojihub.presentation.EmojiUi

data class EmojiScreenState(
    val isFetching: Boolean = false,
    val emojis: Map<String, List<EmojiUi>>? = null
)
