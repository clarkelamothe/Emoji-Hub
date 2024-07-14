package com.clarkelamothe.emojihub.data.di

import androidx.room.Room
import com.clarkelamothe.emojihub.data.database.EmojiDatabase
import com.clarkelamothe.emojihub.data.datasource.RoomLocalEmojiDataSource
import com.clarkelamothe.emojihub.domain.LocalEmojiDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            EmojiDatabase::class.java,
            "emoji-database"
        ).build()
    }
    single { get<EmojiDatabase>().emojiDao }

    singleOf(::RoomLocalEmojiDataSource).bind<LocalEmojiDataSource>()
}
