package com.clarkelamothe.emojihub.domain

import com.clarkelamothe.emojihub.domain.util.DataError
import com.clarkelamothe.emojihub.domain.util.EmptyResult
import kotlinx.coroutines.flow.Flow

interface EmojiRepository {
    fun getEmojis(): Flow<List<Emoji>>
    suspend fun fetchEmojis(): EmptyResult<DataError>
}
