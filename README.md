# 🎥 RTSP Streamer  

An Android application that streams RTSP video using **ExoPlayer** and follows **MVVM architecture** with **Hilt DI**.

---

## 📌 Features  
- Play RTSP streams using **ExoPlayer**  
- **MVVM Architecture** with **Use Case & Repository Pattern**  
- **Hilt Dependency Injection**  
- **LiveData for UI updates**  
- **Clean Code & Modular Approach**  

---

## 🛠 Tech Stack  
- **Language:** Kotlin  
- **Media Streaming:** ExoPlayer  
- **Architecture:** MVVM  
- **Dependency Injection:** Hilt  
- **State Management:** LiveData  
- **UI:** Jetpack ViewBinding  

---

## 🚀 Setup & Run the App  

### 1️⃣ Prerequisites  
- Android Studio **Giraffe or newer**  
- Android Device or Emulator (API 23+)  

### 2️⃣ Clone the Repository  
```bash
git clone https://github.com/Smarshal21/RTSP-Streamer/
cd rtspstreamer
```

### 3️⃣ Open in Android Studio
- Open Android Studio → Click "Open" → Select the project folder.

### 4️⃣ Build & Run
- Connect an Android device or start an emulator.
- Click "Run" ▶️ to launch the app.

## 📂 Project Structure
```perl
com.example.rtspstreamer
│── di/
│   ├── AppModule.kt        # Hilt Dependency Injection
│
│── domain/
│   ├── usecase/
│   │   ├── StartStreamingUseCase.kt  # Business logic for streaming
│
│── data/
│   ├── repository/
│   │   ├── RTSPRepository.kt  # Data handling for ExoPlayer
│
│── app/
│   ├── RTSPStreamerApp.kt   # Application class
│
│── presentation/
│   ├── ui/
│   │   ├── MainActivity.kt  # UI Layer
│   ├── viewmodel/
│   │   ├── StreamViewModel.kt  # Manages UI logic
│   ├── state/
│   │   ├── StreamState.kt  # Defines different stream states
```

## 📝 Usage
### 🎬 Start Streaming
- Enter an RTSP URL in the input field.
- Tap "Start" to begin streaming.
### ⏹ Stop Streaming
- Tap "Stop" to stop playback.

## 🐞 Challenges & Solutions
### 1️⃣ ExoPlayer Initialization Issues
- 🔹 Problem: ExoPlayer would sometimes not load the RTSP stream properly.
- ✅ Solution: Used LiveData & Try-Catch to handle errors gracefully.

### 2️⃣ Background Service for Streaming
- 🔹 Problem: Ensuring the stream runs efficiently.
- ✅ Solution: Used ForegroundService + Hilt to manage lifecycle.
