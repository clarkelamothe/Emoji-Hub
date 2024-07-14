## Emoji Hub App

A simple app that show a list of categorized emojis

From: [Emoji Hub](https://emojihub.yurace.pro/api/all).

## Architecture
Since this app is simple and only consist of a single feature.
I opted for implementing a layered base architecture of
### Data
Here we have the implementations(db, network and repository) of the domain's interfaces.
-> Datasources for remote and local emojis
-> And a di package providing
-> Mappers to map dto and entity models to domain model
### Domain
Nucleo of the app all other layers depend on it, free of android specifics pure kotlin.
### Presentation
-> Contains the intro and emojis screen with viewmodel that make use of the repository and react to the user actions and sending events to the ui and updating state.

Pros: Simple and easy to implement, good separation of layers
Cons: Interdependence of layer, only good for a single feature.

## Libraries
* Kotlin
* Koin
* Jetpack Compose
* Room
* Ktor
* Splashscreen

# Practices
* MVI + Viewmodel + Repository
* Clean Architecture and code
* Offline First App

[Emojihub Challenge.webm](https://github.com/user-attachments/assets/1a50515d-440f-436c-bbfa-775df645ae16)
