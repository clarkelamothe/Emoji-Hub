package com.clarkelamothe.emojihub.presentation.ui

import android.app.Application
import com.clarkelamothe.emojihub.data.di.databaseModule
import com.clarkelamothe.emojihub.data.di.networkModule
import com.clarkelamothe.emojihub.data.di.repositoryModule
import com.clarkelamothe.emojihub.presentation.emojiPresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class EmojiApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@EmojiApp)
            modules(
                networkModule,
                emojiPresentationModule,
                databaseModule,
                repositoryModule
            )
        }
    }
}
