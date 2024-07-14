package com.clarkelamothe.emojihub.data

import com.clarkelamothe.emojihub.domain.util.DataError
import com.clarkelamothe.emojihub.domain.util.EmptyResult
import com.clarkelamothe.emojihub.domain.util.Result
import com.clarkelamothe.emojihub.domain.util.asEmptyDataResult
import com.clarkelamothe.emojihub.domain.Emoji
import com.clarkelamothe.emojihub.domain.EmojiRepository
import com.clarkelamothe.emojihub.domain.LocalEmojiDataSource
import com.clarkelamothe.emojihub.domain.RemoteEmojiDataSource
import kotlinx.coroutines.flow.Flow

class OfflineFirstEmojiRepository(
    private val localEmojiDataSource: LocalEmojiDataSource,
    private val remoteEmojiDataSource: RemoteEmojiDataSource
) : EmojiRepository {
    override fun getEmojis(): Flow<List<Emoji>> {
        return localEmojiDataSource.getEmojis()
    }

    override suspend fun fetchEmojis(): EmptyResult<DataError> {
        return when (
            val result = remoteEmojiDataSource.getEmojis()
        ) {
            is Result.Error -> result.asEmptyDataResult()
            is Result.Success -> localEmojiDataSource.upsertEmojis(result.data).asEmptyDataResult()
        }
    }
}
