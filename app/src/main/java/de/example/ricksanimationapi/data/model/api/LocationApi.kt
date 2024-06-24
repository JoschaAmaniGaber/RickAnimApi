package com.example.rickandmortyguide.data.model.location

data class LocationApi(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val url: String,
    val created: String,

    val residents: List<String>,
)
