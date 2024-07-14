package com.clarkelamothe.emojihub.domain

import com.clarkelamothe.emojihub.domain.util.DataError
import com.clarkelamothe.emojihub.domain.util.Result
import kotlinx.coroutines.flow.Flow

typealias EmojiId = Long

interface LocalEmojiDataSource {
    fun getEmojis(): Flow<List<Emoji>>
    suspend fun upsertEmojis(emojis: List<Emoji>): Result<List<EmojiId>, DataError.Local>
}
