# Simple Video Player for Android

This is a simple video player application for Android that leverages Supabase PostgreSQL for video retrieval, Jetpack Compose for the UI, and Kotlin Coroutines for asynchronous programming.

## Download APK

This is the link for the APK of the app: [Download APK](https://drive.google.com/file/d/1XrxxkBEiAgbm7f66cfdkzhx-ucDCtEUx/view?usp=sharing)

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

![WhatsApp Image 2024-05-10 at 19 45 31_2abe4a11](https://github.com/CUBE2003/Basic-video-player/assets/93052603/9bea2ee4-ab80-4a45-ac89-b5b80761fd93)
![WhatsApp Image 2024-05-10 at 19 45 39_e3eca58a](https://github.com/CUBE2003/Basic-video-player/assets/93052603/641ba269-d568-4adb-985c-e470d5d72436)


https://github.com/CUBE2003/Basic-video-player/assets/93052603/3328332f-92fb-4a75-afa3-9eea93d84347


## Contributing

Contributions are welcome! Feel free to open issues or submit pull requests.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
