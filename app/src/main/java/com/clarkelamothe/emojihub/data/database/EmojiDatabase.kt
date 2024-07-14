package com.clarkelamothe.emojihub.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        EmojiEntity::class
    ],
    version = 1
)
abstract class EmojiDatabase : RoomDatabase() {
    abstract val emojiDao: EmojiDao
}
