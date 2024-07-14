package com.clarkelamothe.emojihub.data.di

import com.clarkelamothe.emojihub.data.OfflineFirstEmojiRepository
import com.clarkelamothe.emojihub.domain.EmojiRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::OfflineFirstEmojiRepository).bind<EmojiRepository>()
}
