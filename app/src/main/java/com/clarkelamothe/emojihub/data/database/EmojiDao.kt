package com.clarkelamothe.emojihub.data.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface EmojiDao {
    @Upsert
    suspend fun upsertEmojis(emojis: List<EmojiEntity>)

    @Query("SELECT * FROM emojientity ORDER BY `group` ASC")
    fun getEmojis(): Flow<List<EmojiEntity>>
}
