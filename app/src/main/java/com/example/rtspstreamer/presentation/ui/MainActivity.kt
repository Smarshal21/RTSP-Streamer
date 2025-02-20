package com.example.rtspstreamer.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.rtspstreamer.presentation.state.StreamState
import com.example.rtspstreamer.presentation.viewmodel.StreamViewModel
import com.example.rtspstreamer.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: StreamViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startButton.setOnClickListener {
            val url = binding.urlEditText.text.toString()
            if (url.isNotEmpty()) {
                viewModel.startStream(url, binding.playerView)
            }
        }

        binding.stopButton.setOnClickListener {
            viewModel.stopStream()
        }

        viewModel.streamState.observe(this) { state ->
            when (state) {
                is StreamState.Playing -> binding.statusText.text = "Playing"
                is StreamState.Stopped -> binding.statusText.text = "Stopped"
                is StreamState.Error -> binding.statusText.text = "Error: ${state.message}"
            }
        }
    }
}
