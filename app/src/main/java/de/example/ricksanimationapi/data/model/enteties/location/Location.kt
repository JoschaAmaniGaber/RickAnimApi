package de.example.ricksanimationapi.data.model.enteties.location

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.squareup.moshi.Json
import de.example.ricksanimationapi.data.model.enteties.character.Character

@Entity(tableName = "locations")
data class Location(

    @PrimaryKey(autoGenerate = false)
    @Json(name = "id") val loId: Int,

    @Json(name = "name") val loName: String,
    @Json(name = "type") val loType: String,
    @Json(name = "dimension") val loDimension: String,
    @Json(name = "url") val loUrl: String,
    @Json(name = "created") val loCreated: String,
    //@Embedded @Json(name = "residents") val loCharacters: LocationWithCharacters
)

// TODO val residents: List<String>, dies ist eine m zu n verbindung

data class LocationWithCharacters(
    @Embedded val location: Location,
    @Relation(
        parentColumn = "loId",
        entityColumn = "chaLocationId"
    )
    val characters: List<Character>
)

data class LocationResult(
    @Json(name = "info") val loInfo: LocationInfo,
    @Json(name = "results") val loResults: List<Location>
)

data class LocationInfo(

    @Json(name = "count") val loCount: Int,
    @Json(name = "pages") val loPages: Int,
    @Json(name = "next") val loNextPage: String?,
    @Json(name = "prev") val loPreviousPage: String?
)
