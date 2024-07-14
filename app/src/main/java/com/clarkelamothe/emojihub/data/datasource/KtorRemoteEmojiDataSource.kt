package com.clarkelamothe.emojihub.data.datasource

import com.clarkelamothe.emojihub.data.networking.EmojiDto
import com.clarkelamothe.emojihub.domain.util.DataError
import com.clarkelamothe.emojihub.domain.util.Result
import com.clarkelamothe.emojihub.domain.util.map
import com.clarkelamothe.emojihub.data.networking.get
import com.clarkelamothe.emojihub.data.toEmoji
import com.clarkelamothe.emojihub.domain.Emoji
import com.clarkelamothe.emojihub.domain.RemoteEmojiDataSource
import io.ktor.client.HttpClient

class KtorRemoteEmojiDataSource(
    private val httpClient: HttpClient
) : RemoteEmojiDataSource {
    override suspend fun getEmojis(): Result<List<Emoji>, DataError.Network> {
        return httpClient.get<List<EmojiDto>>(
            route = "/api/all"
        ).map { emojiDtos ->
            emojiDtos.map { it.toEmoji() }
        }
    }
}
