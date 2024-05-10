package com.example.basic.presentation.viewmodel



import SupabaseRepository
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basic.data.model.VideoDetails
import kotlinx.coroutines.launch

// ViewModel
class AppViewModel : ViewModel() {
    private val supabaseRepository = SupabaseRepository()

    var searchText by mutableStateOf("")

    fun onSearchTextChanged(newText: String) {
        searchText = newText
    }

    private val _videoDetails = MutableLiveData<List<VideoDetails>>()
    val videoDetails: LiveData<List<VideoDetails>> get() = _videoDetails

    fun fetchVideoDetails() {
        viewModelScope.launch {
            _videoDetails.value = supabaseRepository.getVideoDetails().value
        }
    }

    fun searchVideos() {
        viewModelScope.launch {
            try {
                if (searchText.isNotBlank()) { // Ensure there's a search query
                    val searchResults = supabaseRepository.searchVideos(searchText)
                    Log.d("AppViewModel", "Search results: $searchResults")
                    _videoDetails.value = searchResults
                } else {
                    // Handle the case where the search text is empty
                    // You might want to clear the results or show a message
                    _videoDetails.value = emptyList()
                }
            } catch (e: Exception) {
                Log.e("AppViewModel", "Error searching videos: ", e)
                // Handle errors as needed, e.g., show an error message
            }
        }
    }
}



