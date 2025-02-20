package com.example.rtspstreamer.presentation.state

sealed class StreamState {
    object Playing : StreamState()
    object Stopped : StreamState()
    data class Error(val message: String) : StreamState()
}
