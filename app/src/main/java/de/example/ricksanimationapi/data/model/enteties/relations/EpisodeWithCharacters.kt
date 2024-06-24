package de.example.ricksanimationapi.data.model.enteties.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import de.example.ricksanimationapi.data.model.enteties.CharacterEntity
import de.example.ricksanimationapi.data.model.enteties.CharacterEpisodeCrossRef
import de.example.ricksanimationapi.data.model.enteties.EpisodeEntity

data class EpisodeWithCharacters(
    @Embedded val episodeEntity: EpisodeEntity,
    @Relation(
        parentColumn = "episode_id",
        entityColumn = "character_id",
        associateBy = Junction(CharacterEpisodeCrossRef::class)
    )
    val characters: List<CharacterEntity>
)
