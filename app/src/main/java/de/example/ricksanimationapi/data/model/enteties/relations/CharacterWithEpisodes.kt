package de.example.ricksanimationapi.data.model.enteties.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import de.example.ricksanimationapi.data.model.enteties.CharacterEntity
import de.example.ricksanimationapi.data.model.enteties.CharacterEpisodeCrossRef
import de.example.ricksanimationapi.data.model.enteties.EpisodeEntity

data class CharacterWithEpisodes(
    @Embedded val characterEntity: CharacterEntity,
    @Relation(
        parentColumn = "character_id",
        entityColumn = "episode_id",
        associateBy = Junction(CharacterEpisodeCrossRef::class)
    )
    val episodes: List<EpisodeEntity>
)
