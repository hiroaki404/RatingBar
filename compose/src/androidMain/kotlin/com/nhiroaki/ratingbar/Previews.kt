package com.nhiroaki.ratingbar

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun RatingBarPreview() {
    RatingBar(
        value = 3.5f,
        onValueChange = { },
    )
}
