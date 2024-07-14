package com.clarkelamothe.emojihub.presentation

import com.clarkelamothe.emojihub.domain.Emoji

fun Emoji.toEmojiUi(): EmojiUi {
    return EmojiUi(
        id = id.toString(),
        name = name,
        category = category,
        group = group,
        unicode = unicode
    )
}

data class EmojiUi(
    val id: String?,
    val name: String,
    val category: String,
    val group: String,
    val unicode: String
)
