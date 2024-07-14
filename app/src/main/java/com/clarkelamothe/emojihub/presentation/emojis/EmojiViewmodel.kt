package com.clarkelamothe.emojihub.presentation.emojis

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clarkelamothe.emojihub.domain.util.Result
import com.clarkelamothe.emojihub.presentation.ui.util.UiText
import com.clarkelamothe.emojihub.presentation.ui.util.asUiText
import com.clarkelamothe.emojihub.domain.EmojiRepository
import com.clarkelamothe.emojihub.presentation.EmojiUi
import com.clarkelamothe.emojihub.presentation.toEmojiUi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class EmojiViewmodel(
    private val repository: EmojiRepository
) : ViewModel() {
    var state by mutableStateOf(EmojiScreenState())
        private set

    private val _event = Channel<EmojiEvent>()
    val event = _event.receiveAsFlow()

    init {
        getEmojis()
    }

    private fun getEmojis() {
        repository.getEmojis().onEach { emojis ->
            emojis.ifEmpty {
                fetchEmojis()
            }
            val emojisUi = emojis.map { it.toEmojiUi() }
            state = state.copy(emojis = emojisUi.distinct().groupBy { it.category })
        }.launchIn(viewModelScope)
    }

    private fun fetchEmojis() {
        viewModelScope.launch {
            state = state.copy(isFetching = true)
            when (val remoteEmoji = repository.fetchEmojis()) {
                is Result.Error -> {
                    _event.send(
                        EmojiEvent.Error(
                            remoteEmoji.error.asUiText()
                        )
                    )
                }

                is Result.Success -> Unit
            }
            state = state.copy(isFetching = false)
        }
    }

    fun onAction(action: EmojiScreenAction) {
        when (action) {
            EmojiScreenAction.Retry -> fetchEmojis()
        }
    }
}

sealed interface EmojiEvent {
    data class Error(val error: UiText) : EmojiEvent
}

sealed interface EmojiScreenAction {
    data object Retry : EmojiScreenAction
}
