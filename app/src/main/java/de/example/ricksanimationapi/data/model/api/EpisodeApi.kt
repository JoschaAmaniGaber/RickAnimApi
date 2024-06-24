package com.example.rickandmortyguide.data.model.episode

import androidx.room.PrimaryKey

data class EpisodeApi(

    val id: Int,
    val name: String,
    val air_date: String,
    val characters: List<String>,
    val url: String,
    val created: String
)
