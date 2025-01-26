# RatingBar

<img src="https://github.com/user-attachments/assets/f40a0bb9-21d0-4712-a175-82584c5cddda" width="400">

RatingBar is a library for implementing a rating bar in Compose Multiplatform. This library allows
you to easily add a rating bar to both Android and iOS applications. Of course, it can be used not
only with Compose Multiplatform, but also with Android's Compose.

## Features

- Works on both Android and iOS
- Customizable rating bar
- Easy integration

## Installation

Add the following dependency to your `build.gradle.kts`:

```kotlin
dependencies {
    implementation("io.github.hiroaki404.ratingbar:$version")
}
```

## Usage

```kotlin
var rating by remember { mutableFloatStateOf(3f) }

RatingBar(
    value = rating,
    onValueChange = { rating = it },
)
```

## Customization

RatingBar can be customized as follows:

Please see the KDoc for details.

```kotlin
var rating by remember { mutableFloatStateOf(3.5f) }

RatingBar(
    value = rating,
    onValueChange = { rating = it },
    numOfSteps = 10,
    stepSize = StepSize.HALF,
    spaceBetween = 4.dp,
    modifier = modifier.background(Color.Black),
)
```

## Image Customization

You can use images other than stars as well.

![Image](https://github.com/user-attachments/assets/a7ee45b2-90df-4235-bd4f-ee0c4e2a538e)

```kotlin
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
```

## License

```
Copyright 2025 hiroaki404

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
