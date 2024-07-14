package com.clarkelamothe.emojihub.data.database

import com.clarkelamothe.emojihub.domain.Emoji

fun EmojiEntity.toEmoji(): Emoji {
    return Emoji(
        id = id,
        name = name,
        category = category,
        group = group,
        unicode = unicode
    )
}

fun Emoji.toEntity(): EmojiEntity {
    return EmojiEntity(
        name = name,
        category = category,
        group = group,
        unicode = unicode
    )
}
