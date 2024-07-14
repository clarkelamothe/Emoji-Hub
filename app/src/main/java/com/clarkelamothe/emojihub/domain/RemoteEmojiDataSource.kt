package com.clarkelamothe.emojihub.domain

import com.clarkelamothe.emojihub.domain.util.DataError
import com.clarkelamothe.emojihub.domain.util.Result

interface RemoteEmojiDataSource {
    suspend fun getEmojis():
            Result<List<Emoji>, DataError.Network>
}
