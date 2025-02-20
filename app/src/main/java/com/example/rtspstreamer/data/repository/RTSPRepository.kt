package com.example.rtspstreamer.data.repository

import androidx.media3.common.MediaItem
import androidx.media3.common.MimeTypes
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import javax.inject.Inject

class RTSPRepository @Inject constructor(private val exoPlayer: ExoPlayer) {

    fun startStream(url: String, playerView: PlayerView) {
        val mediaItem = MediaItem.Builder()
            .setUri(url)
            .setMimeType(MimeTypes.APPLICATION_RTSP)
            .build()

        exoPlayer.setMediaItem(mediaItem)
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true
        playerView.player = exoPlayer
    }

    fun stopStream() {
        exoPlayer.stop()
        exoPlayer.clearMediaItems()
    }
}
