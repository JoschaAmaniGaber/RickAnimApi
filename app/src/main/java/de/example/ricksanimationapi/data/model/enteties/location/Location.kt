package com.example.rickandmortyguide.data.model.location

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.squareup.moshi.Json
import de.example.ricksanimationapi.data.model.enteties.character.Character

@Entity(tableName = "locations")
data class Location(

    @PrimaryKey(autoGenerate = false)
    @Json(name = "name") val lo_name: String,

    @Json(name = "id") val lo_id: Int,
    @Json(name = "type") val lo_type: String,
    @Json(name = "dimension") val lo_dimension: String,
    @Json(name = "url") val lo_url: String,
    @Json(name = "created") val lo_created: String,
//    @Json(name = "residents") val lo_characters: LocationWithCharacters
)

// TODO val residents: List<String>, dies ist eine m zu n verbindung

data class LocationWithCharacters(
    @Embedded val location: Location,
    @Relation(
        parentColumn = "lo_name",
        entityColumn = "cha_location_name"
    )
    val characters: List<Character>
)

data class LocationResult(
    @Json(name = "info") val lo_info: LocationInfo,
    @Json(name = "results") val lo_results: List<Location>
)

data class LocationInfo(

    @Json(name = "count") val lo_count: Int,
    @Json(name = "pages") val lo_pages: Int,
    @Json(name = "next") val lo_next_page: String?,
    @Json(name = "prev") val lo_previous_page: String?
)
