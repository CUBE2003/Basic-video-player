package com.example.basic

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.media3.exoplayer.ExoPlayer
import com.example.basic.data.model.VideoDetails
import com.example.basic.presentation.composables.PlayerCard
import com.example.basic.presentation.composables.VideoTextField
import com.example.basic.presentation.ui.theme.BASICTheme
import com.example.basic.presentation.viewmodel.AppViewModel


class MainActivity : ComponentActivity() {
    private val viewModel: AppViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val exoPlayerPool = ArrayDeque<ExoPlayer>().apply {
            repeat(10) {
                add(ExoPlayer.Builder(applicationContext).build())
            }
        }

        enableEdgeToEdge()
        setContent {
            BASICTheme(darkTheme = true) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Column(
                        modifier = Modifier.padding(top = 48.dp), // Add top padding
                    ) {

                        VideoTextField(
                            search = viewModel.searchText,
                            onTextChange = viewModel::onSearchTextChanged,
                            onSearchClick = { viewModel.searchVideos() }
                        )

                        Spacer(modifier = Modifier.height(4.dp))
                        VideoApp(viewModel)
                    }


                }
            }
        }
    }


    @Composable
    fun VideoApp(viewModel: AppViewModel) {
        var videoDetails by remember { mutableStateOf<List<VideoDetails>>(emptyList()) }
        var showLoading by remember { mutableStateOf(false) }
        LaunchedEffect(Unit) {
            showLoading = true
            viewModel.fetchVideoDetails()
            showLoading = false
        }
        viewModel.videoDetails.observe(this) { details ->
            Log.d("VideoApp", "Observed video details: $details")
            videoDetails = details
        }







        Scaffold { paddingValues ->
            if (showLoading) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            } else {
                LazyColumn(contentPadding = paddingValues) {
                    items(videoDetails, key = { it.id }) { detail -> // Unique key for items
                        PlayerCard(
                            title = detail.title,
                            description = detail.description,
                            videoUrl = detail.storage_path
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }


    }


}







