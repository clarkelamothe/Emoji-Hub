package com.clarkelamothe.emojihub.presentation.ui.util

import com.clarkelamothe.emojihub.R
import com.clarkelamothe.emojihub.domain.util.DataError

fun DataError.asUiText(): UiText {
    return when (this) {
        DataError.Local.DISK_FULL -> UiText.StringResource(R.string.disk_full)
        DataError.Network.REQUEST_TIMEOUT -> UiText.StringResource(R.string.request_took_too_much_time)
        DataError.Network.NO_INTERNET -> UiText.StringResource(R.string.no_internet)
        DataError.Network.SERVER_ERROR -> UiText.StringResource(R.string.server_error_text)
        else -> UiText.StringResource(R.string.unknown_error)
    }
}
