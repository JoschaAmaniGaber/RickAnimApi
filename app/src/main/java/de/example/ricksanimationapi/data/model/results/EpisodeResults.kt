package com.example.rickandmortyguide.data.model.episode

import com.example.rickandmortyguide.data.model.info.EpisodeInfo
import com.squareup.moshi.Json

data class EpisodeResults(

    @Json(name = "info")
    val episodeInfo: EpisodeInfo,

    val results: List<EpisodeApi>
)

