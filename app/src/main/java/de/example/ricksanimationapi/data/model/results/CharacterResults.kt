package com.example.rickandmortyguide.data.model.character

import com.example.rickandmortyguide.data.model.info.CharacterInfo
import com.squareup.moshi.Json
import de.example.ricksanimationapi.data.model.api.CharacterFromApi

data class CharacterResults(

    @Json(name = "info")
    var characterInfo: CharacterInfo,

    var results: List<CharacterFromApi>
)
