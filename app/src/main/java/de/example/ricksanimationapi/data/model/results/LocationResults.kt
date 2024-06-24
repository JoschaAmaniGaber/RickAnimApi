package com.example.rickandmortyguide.data.model.location

import com.example.rickandmortyguide.data.model.info.LocationInfo
import com.squareup.moshi.Json

data class LocationResults(

    @Json(name = "info")
    val locationInfo: LocationInfo,

    val results: List<LocationApi>
)
