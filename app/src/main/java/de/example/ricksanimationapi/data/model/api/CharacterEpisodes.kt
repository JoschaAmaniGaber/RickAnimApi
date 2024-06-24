package de.example.ricksanimationapi.data.model.api

import com.squareup.moshi.Json

data class CharacterEpisodes(

    @Json(name = "episode")
    val episodes: List<String>

)