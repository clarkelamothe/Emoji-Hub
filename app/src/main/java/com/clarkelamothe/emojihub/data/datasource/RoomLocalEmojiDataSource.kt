package com.clarkelamothe.emojihub.data.datasource

import android.database.sqlite.SQLiteFullException
import com.clarkelamothe.emojihub.data.database.EmojiDao
import com.clarkelamothe.emojihub.data.database.toEmoji
import com.clarkelamothe.emojihub.data.database.toEntity
import com.clarkelamothe.emojihub.domain.util.DataError
import com.clarkelamothe.emojihub.domain.util.Result
import com.clarkelamothe.emojihub.domain.Emoji
import com.clarkelamothe.emojihub.domain.EmojiId
import com.clarkelamothe.emojihub.domain.LocalEmojiDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RoomLocalEmojiDataSource(
    private val emojiDao: EmojiDao
) : LocalEmojiDataSource {
    override fun getEmojis(): Flow<List<Emoji>> {
        return emojiDao.getEmojis().map { emojiEntities ->
            emojiEntities.map { it.toEmoji() }
        }
    }

    override suspend fun upsertEmojis(emojis: List<Emoji>): Result<List<EmojiId>, DataError.Local> {
        return try {
            val entities = emojis.map { it.toEntity() }
            emojiDao.upsertEmojis(entities)
            Result.Success(entities.map { it.id })
        } catch (e: SQLiteFullException) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }
}
