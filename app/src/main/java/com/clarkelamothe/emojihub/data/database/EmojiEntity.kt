package com.clarkelamothe.emojihub.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EmojiEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val category: String,
    val group: String,
    val unicode: String
)
