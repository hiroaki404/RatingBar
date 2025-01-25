/*
 * Copyright 2025 hiroaki404/nhiroaki
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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun RatingBarSamples(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(
            16.dp,
        ),
    ) {
        Column {
            Text("RatingBar")
            RatingBarSample()
        }
        Column {
            Text("RatingBarImageCustomization")
            RatingBarImageCustomizationSample()
        }
        Column {
            Text("RatingBarAsIndicator")
            RatingBarAsIndicatorSample()
        }
    }
}

@Composable
fun RatingBarSample() {
    var rating by remember { mutableFloatStateOf(3.5f) }

    RatingBar(
        value = rating,
        onValueChange = { rating = it },
    )
}

@Composable
fun RatingBarImageCustomizationSample() {
    var rating by remember { mutableFloatStateOf(3.5f) }

    RatingBar(
        value = rating,
        onValueChange = { rating = it },
        ratingContent = {
            Icon(
                imageVector = Icons.Rounded.Call,
                contentDescription = null,
                tint = defaultStarColor,
            )
        },
        inactiveContent = {
            Icon(
                imageVector = Icons.Rounded.Call,
                contentDescription = null,
                tint = defaultInactiveStarColor,
            )
        },
    )
}

@Composable
fun RatingBarAsIndicatorSample() {
    RatingBarAsIndicator(
        value = 3.5f,
    )
}

@Preview
@Composable
private fun RatingBarPreview() {
    RatingBarSample()
}

@Preview
@Composable
private fun RatingBarAsIndicatorPreview() {
    RatingBarAsIndicatorSample()
}
