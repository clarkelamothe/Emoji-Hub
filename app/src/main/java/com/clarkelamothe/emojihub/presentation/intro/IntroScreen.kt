package com.clarkelamothe.emojihub.presentation.intro

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.clarkelamothe.emojihub.R
import com.clarkelamothe.emojihub.presentation.ui.components.EmojiHubFAB

@Composable
fun IntroScreenRoot(
    navigateToEmojis: () -> Unit
) {
    IntroScreen(
        onAction = { navigateToEmojis() }
    )
}

@Composable
fun IntroScreen(
    onAction: (IntroScreenAction) -> Unit
) {
    Scaffold(
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            EmojiHubFAB(
                modifier = Modifier,
                contentDescription = stringResource(R.string.show_emojis),
                onClick = { onAction(IntroScreenAction.OnShowEmojiClick) }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = paddingValues.calculateTopPadding()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = stringResource(R.string.welcome_text),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Preview
@Composable
private fun IntroScreenPreview() {
    IntroScreen(
        onAction = {},
    )
}
