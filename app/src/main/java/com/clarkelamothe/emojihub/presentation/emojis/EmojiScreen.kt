package com.clarkelamothe.emojihub.presentation.emojis

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.clarkelamothe.emojihub.R
import com.clarkelamothe.emojihub.presentation.ui.components.EmojiGrid
import com.clarkelamothe.emojihub.presentation.ui.components.Loading
import com.clarkelamothe.emojihub.presentation.ui.util.ObserveAsEvents
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun EmojiScreenRoot(
    viewmodel: EmojiViewmodel = koinViewModel()
) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }

    ObserveAsEvents(flow = viewmodel.event) {
        when (it) {
            is EmojiEvent.Error -> {
                scope.launch {
                    val result = snackbarHostState.showSnackbar(
                        actionLabel = context.getString(R.string.retry),
                        message = it.error.asString(context),
                        duration = SnackbarDuration.Indefinite
                    )
                    when (result) {
                        SnackbarResult.Dismissed -> {}
                        SnackbarResult.ActionPerformed -> {
                            viewmodel.onAction(EmojiScreenAction.Retry)
                        }
                    }
                }
            }

            else -> Unit
        }
    }

    EmojiScreen(
        snackbarHostState = snackbarHostState,
        state = viewmodel.state,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun EmojiScreen(
    modifier: Modifier = Modifier,
    snackbarHostState: SnackbarHostState,
    state: EmojiScreenState
) {
    Scaffold(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surface,
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { paddingValues ->
        Loading(show = state.isFetching, modifier = modifier)
        EmptyStateScreen(
            show = !state.isFetching && state.emojis?.isEmpty() == true,
            description = stringResource(id = R.string.no_emojis)
        )
        state.emojis?.let {
            EmojiGrid(
                modifier,
                paddingValues,
                it
            )
        }
    }
}

@Preview
@Composable
private fun EmojiScreenPreview() {
    EmojiScreen(
        state = EmojiScreenState(
            isFetching = false,
            emojis = emptyMap()
        ),
        snackbarHostState = SnackbarHostState()
    )
}
