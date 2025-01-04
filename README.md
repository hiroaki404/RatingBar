# RatingBar

RatingBar is a library for implementing a rating bar in Compose Multiplatform. This library allows
you to easily add a rating bar to both Android and iOS applications.

## Features

- Works on both Android and iOS
- Customizable rating bar
- Easy integration

## Installation

- Work in progress

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
    var rating by remember { mutableFloatStateOf(3f) }

    RatingBar(
        value = rating,
        onValueChange = { rating = it },
        numberOfStars = 10,
        spaceBetween = 10.dp,
    )
```

## License

```
Copyright 2025 hiroaki404/nhiroaki

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
