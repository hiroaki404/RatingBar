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

This project is licensed under the MIT License. See the `LICENSE` file for details.
