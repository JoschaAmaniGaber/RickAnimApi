package de.example.ricksanimationapi.data.model.enteties

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "episodes")
data class EpisodeEntity(

    @PrimaryKey
    val episode_id: Int,
    val episode_name: String,
    val episode_air_date: String,
    val episode_url: String,
    val episode_created: String,

//    @Ignore val characters: List<String> = listOf(),
)
