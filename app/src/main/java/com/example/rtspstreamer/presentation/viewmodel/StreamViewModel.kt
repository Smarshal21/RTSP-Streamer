package com.example.rtspstreamer.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.media3.ui.PlayerView
import com.example.rtspstreamer.data.repository.RTSPRepository
import com.example.rtspstreamer.domain.usecase.StartStreamingUseCase
import com.example.rtspstreamer.presentation.state.StreamState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StreamViewModel @Inject constructor(
    private val startStreamingUseCase: StartStreamingUseCase,
    private val repository: RTSPRepository
) : ViewModel() {

    private val _streamState = MutableLiveData<StreamState>()
    val streamState: LiveData<StreamState> = _streamState

    fun startStream(url: String, playerView: PlayerView) {
        try {
            startStreamingUseCase.execute(url, playerView)
            _streamState.postValue(StreamState.Playing)
        } catch (e: Exception) {
            _streamState.postValue(StreamState.Error(e.message ?: "Unknown Error"))
        }
    }

    fun stopStream() {
        repository.stopStream()
        _streamState.postValue(StreamState.Stopped)
    }
}
