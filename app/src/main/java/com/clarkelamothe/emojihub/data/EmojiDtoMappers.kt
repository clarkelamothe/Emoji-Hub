package com.clarkelamothe.emojihub.data

import com.clarkelamothe.emojihub.data.networking.EmojiDto
import com.clarkelamothe.emojihub.domain.Emoji
import java.lang.StringBuilder

fun EmojiDto.toEmoji(): Emoji {
    return Emoji(
        id = null,
        name = name,
        category = category,
        group = group,
        unicode = toEmoji(unicode)
    )
}

private fun toEmoji(unicodes: List<String>): String {
    val stringBuilder = StringBuilder()
    unicodes.forEach { code ->
        val intCode = Integer.decode(code.replace("U+", "0x"))
        stringBuilder.append(String(Character.toChars(intCode)))
    }
    return stringBuilder.toString()
}
