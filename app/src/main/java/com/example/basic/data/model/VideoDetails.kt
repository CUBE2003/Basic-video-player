package com.example.basic.data.model

import kotlinx.serialization.Serializable

@Serializable
data class VideoDetails(
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val storage_path: String = ""
)
