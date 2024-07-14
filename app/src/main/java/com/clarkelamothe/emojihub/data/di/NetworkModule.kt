package com.clarkelamothe.emojihub.data.di

import com.clarkelamothe.emojihub.data.datasource.KtorRemoteEmojiDataSource
import com.clarkelamothe.emojihub.data.networking.HttpClientFactory
import com.clarkelamothe.emojihub.domain.RemoteEmojiDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule = module {
    single {
        HttpClientFactory().build()
    }
    singleOf(::KtorRemoteEmojiDataSource).bind<RemoteEmojiDataSource>()
}
