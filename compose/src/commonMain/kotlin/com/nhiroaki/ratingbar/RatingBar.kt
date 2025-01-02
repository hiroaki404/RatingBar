package com.nhiroaki.ratingbar

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun RatingBar(
    value: Float,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
    numOfSteps: Int = 5,
    stepSize: Float = 1.0f,
    spaceBetween: Dp = 2.dp,
    ratingContent: @Composable () -> Unit = {
        RatingBarDefaults.RatingContent()
    },
    inactiveContent: @Composable () -> Unit = {
        RatingBarDefaults.InactiveContent()
    },
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(spaceBetween),
    ) {
        (1..numOfSteps).forEach { index ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .pointerInput(Unit) {
                        detectTapGestures {
                            onValueChange(index.toFloat())
                        }
                    },
            ) {
                inactiveContent()

                if (index <= value) {
                    ratingContent()
                }
            }
        }
    }
}

// TODO: implements this
/**
 * Rating bar that should only be used as an indicator. It does not allow user interaction.
 *
 */
// @Composable
// fun RatingBarAsIndicator(
// ) {
//
// }

object RatingBarDefaults {
    @Composable
    fun RatingContent(color: Color = DefaultStarColor, modifier: Modifier = Modifier) {
        Icon(
            tint = color,
            imageVector = Icons.Rounded.Star,
            modifier = modifier,
            contentDescription = "Rated Star",
        )
    }

    @Composable
    fun InactiveContent(color: Color = DefaultInactiveStarColor, modifier: Modifier = Modifier) {
        Icon(
            tint = color,
            imageVector = Icons.Rounded.Star,
            modifier = modifier,
            contentDescription = "Unrated Star",
        )
    }
}
