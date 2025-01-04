/*
 * Copyright 2025 hiroaki404/nhiroaki
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 *
 */

package com.nhiroaki.ratingbar

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * A composable function that displays a rating bar. This rating bar is designed to be generic and can be used with any composable, not just stars. Users can change the rating value through user interaction.
 *
 * @param value The current rating value.
 * @param onValueChange A callback that is invoked when the rating value changes.
 * @param modifier The [Modifier] to be applied to this composable.
 * @param numOfSteps The number of steps in the rating bar. The default value is 5.
 * @param stepSize The value of each step. The default value is 1.0f.
 * @param spaceBetween The space between each step. The default value is 2.dp.
 * @param ratingContent The content to be displayed for each rated step. The default is [RatingBarDefaults.RatingContent].
 * @param inactiveContent The content to be displayed for each unrated step. The default is [RatingBarDefaults.InactiveContent].
 *
 * @sample com.nhiroaki.ratingbar.RatingBarSample
 */
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

/**
 * The default color for rated contents. The default icon is a star.
 */
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

@Composable
fun RatingBarSample() {
    var rating by remember { mutableFloatStateOf(3f) }

    RatingBar(
        value = rating,
        onValueChange = { rating = it },
    )
}
