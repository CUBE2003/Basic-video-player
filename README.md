# Simple Video Player for Android

This is a simple video player application for Android that leverages Supabase PostgreSQL for video retrieval, Jetpack Compose for the UI, and Kotlin Coroutines for asynchronous programming.

## Features

- **Supabase Integration:** Utilizes Supabase to manage video details and storage. Videos are stored in a designated bucket, and their URLs or bucket paths are stored in the PostgreSQL database.
  
- **ExoPlayer for Video Playback:** Relies on ExoPlayer, a media player library by Google, for smooth video playback.

- **Search Functionality:** Implements a search feature to easily find specific videos.

- **MVVM Architecture:** Follows the Model-View-ViewModel (MVVM) architectural pattern for clean separation of concerns and easier maintenance. In MVVM, the Model represents the data and business logic, the View displays the UI, and the ViewModel acts as a mediator between the Model and View.

- **Network Calls:** Utilizes the Supabase built-in library for network calls, which internally employs Ktor, a powerful networking library for Kotlin.

## Setup

### Supabase Configuration

1. Create a new database in Supabase and define a table to store video details.
2. Create a new bucket in Supabase where all the videos will be stored.
3. Store the video URLs or bucket paths in the PostgreSQL database.

### Dependencies

Ensure the following dependencies are added to your Android project:
- Jetpack Compose
- Kotlin Coroutines
- ExoPlayer
- Supabase Kotlin library
- Ktor

## Usage

1. Clone the repository.
2. Open the project in Android Studio.
3. Build and run the application on an Android device or emulator.

## Screenshots/Videos

[Insert screenshots or videos here]

## Contributing

Contributions are welcome! Feel free to open issues or submit pull requests.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
