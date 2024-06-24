package de.example.ricksanimationapi.data.model.enteties

import androidx.room.Entity

@Entity(
    tableName = "character_episode_cross_ref",
    primaryKeys = [
        "character_id",
        "episode_id"
    ]
)
data class CharacterEpisodeCrossRef(
    val character_id: Int,
    val episode_id: Int
)
