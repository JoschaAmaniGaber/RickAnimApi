package de.example.ricksanimationapi.data.model.enteties.character

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import java.net.URI

@Entity(tableName = "characters")
data class Character(

    @PrimaryKey
    @Json(name = "id") val cha_id: Int,
    @Json(name = "name") val cha_name: String,
    @Json(name = "status") val cha_status: String,
    @Json(name = "species") val cha_species: String,
    @Json(name = "type") val cha_type: String,
    @Json(name = "gender") val cha_gender: String,
    @Json(name = "image") val cha_image: String,
    @Json(name = "url") val cha_url: String,
    @Json(name = "created") val cha_created: String,
    @Embedded @Json(name = "origin") val cha_origin: ChaOrigin,
    @Embedded @Json(name = "location") val cha_location: ChaLocation,
)

fun extractIdFromLocationUrl(url: String): Int {
    if (url != "") {
        val uri = URI(url)
        val path = uri.path
        val idStr = path.substring(path.lastIndexOf('/') + 1)
        val id = idStr.toInt()

        return id
    } else return 0
}



