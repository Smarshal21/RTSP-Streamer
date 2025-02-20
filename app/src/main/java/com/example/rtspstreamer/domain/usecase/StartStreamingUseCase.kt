package com.example.rtspstreamer.domain.usecase

import androidx.media3.ui.PlayerView
import com.example.rtspstreamer.data.repository.RTSPRepository
import javax.inject.Inject

class StartStreamingUseCase @Inject constructor(private val repository: RTSPRepository) {
    fun execute(url: String, playerView: PlayerView) {
        repository.startStream(url, playerView)
    }
}
