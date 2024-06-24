package de.example.ricksanimationapi.data.model.enteties

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import de.example.ricksanimationapi.data.model.api.CharacterEpisodes
import java.net.URI

@Entity(
    tableName = "characters")
data class CharacterEntity(
    @PrimaryKey
    val character_id: Int,
    val character_name: String,
    val character_status: String,
    val character_species: String,
    val character_type: String,
    val character_gender: String,
    val character_origin_name: String,
    val character_location_id: Int,
    val character_image: String,
//    val character_episode: CharacterEpisodes,
    val character_url: String,
    val character_created: String
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