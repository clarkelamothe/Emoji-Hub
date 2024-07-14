package com.clarkelamothe.emojihub.presentation.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.clarkelamothe.emojihub.R

@Preview
@Composable
fun EmojiHubFAB(
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    onClick: () -> Unit = {}
) {
    ExtendedFloatingActionButton(
        onClick = onClick,
        modifier = modifier,
        text = {
            Text(text = stringResource(id = R.string.show_emojis))
        },
        icon = {
            Icon(Icons.Filled.Refresh, stringResource(R.string.extended_floating_action_button))
        }
    )
}
