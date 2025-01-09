/*
 * Copyright 2025 hiroaki404
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 *
 */

package io.github.hiroaki404.ratingbar

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
 * @sample io.github.hiroaki404.ratingbar.RatingBarSample
 */
@Composable
fun RatingBar(
    value: Float,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
    numOfSteps: Int = 5,
//    stepSize: Float = 1.0f,
    spaceBetween: Dp = 2.dp,
    ratingContent: @Composable () -> Unit = {
        RatingBarDefaults.RatingContent()
    },
    inactiveContent: @Composable () -> Unit = {
        RatingBarDefaults.InactiveContent()
    },
) {
    RatingBarBasic(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        numOfSteps = numOfSteps,
        spaceBetween = spaceBetween,
        ratingContent = ratingContent,
        inactiveContent = inactiveContent,
    )
}

/**
 * Rating bar that should only be used as an indicator. It does not allow user interaction.
 * @param value The current rating value.
 * @param modifier The [Modifier] to be applied to this composable.
 * @param numOfSteps The number of steps in the rating bar. The default value is 5.
 * @param stepSize The value of each step. The default value is 1.0f.
 * @param spaceBetween The space between each step. The default value is 2.dp.
 * @param ratingContent The content to be displayed for each rated step. The default is [RatingBarDefaults.RatingContent].
 * @param inactiveContent The content to be displayed for each unrated step. The default is [RatingBarDefaults.InactiveContent].
 */
@Composable
fun RatingBarAsIndicator(
    value: Float,
    modifier: Modifier = Modifier,
    numOfSteps: Int = 5,
//    stepSize: Float = 1.0f,
    spaceBetween: Dp = 2.dp,
    ratingContent: @Composable () -> Unit = {
        RatingBarDefaults.RatingContent()
    },
    inactiveContent: @Composable () -> Unit = {
        RatingBarDefaults.InactiveContent()
    },
) {
    RatingBarBasic(
        value = value,
        onValueChange = null,
        modifier = modifier,
        numOfSteps = numOfSteps,
        spaceBetween = spaceBetween,
        ratingContent = ratingContent,
        inactiveContent = inactiveContent,
    )
}

@Composable
private fun RatingBarBasic(
    value: Float,
    onValueChange: ((Float) -> Unit)?,
    modifier: Modifier = Modifier,
    numOfSteps: Int = 5,
//    stepSize: Float = 1.0f,
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
                            onValueChange?.invoke(index.toFloat())
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
fun RatingBarSample(modifier: Modifier = Modifier) {
    var rating by remember { mutableFloatStateOf(3f) }

    RatingBar(
        modifier = modifier,
        value = rating,
        onValueChange = { rating = it },
    )
}
