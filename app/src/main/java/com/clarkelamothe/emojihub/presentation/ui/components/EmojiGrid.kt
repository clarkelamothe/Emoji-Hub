package com.clarkelamothe.emojihub.presentation.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.clarkelamothe.emojihub.presentation.EmojiUi

@Composable
fun EmojiGrid(
    modifier: Modifier,
    paddingValues: PaddingValues,
    emojis: Map<String, List<EmojiUi>>
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(5),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .padding(top = paddingValues.calculateTopPadding() + 8.dp)
            .padding(horizontal = 8.dp)
    ) {
        emojis.forEach { (category, emojis) ->
            item(span = { GridItemSpan(maxLineSpan) }) {
                Text(
                    text = category.replaceFirstChar { it.uppercaseChar() },
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .fillMaxWidth()
                        .border(
                            border = BorderStroke(
                                width = 1.dp,
                                color = MaterialTheme.colorScheme.primaryContainer
                            )
                        )
                        .padding(16.dp)
                )
            }

            items(
                items = emojis,
                key = { it.id!! },
                span = { GridItemSpan(1) }
            ) {
                Text(
                    text = it.unicode,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                )
            }
        }
    }
}