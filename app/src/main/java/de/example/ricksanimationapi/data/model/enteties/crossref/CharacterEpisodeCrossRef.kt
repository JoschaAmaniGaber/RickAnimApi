package de.example.ricksanimationapi.data.model.enteties.crossref

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation
import de.example.ricksanimationapi.data.model.enteties.character.Character
import de.example.ricksanimationapi.data.model.enteties.episode.Episode

@Entity(tableName = "character_episode_cross_ref",
    primaryKeys = [
        "cha_id",
        "epi_id"
    ])
data class CharacterEpisodeCrossRef(
    val cha_id: Int,
    val epi_id: Int
)

data class EpisodeWithCharacters(
    @Embedded val episode: Episode,
    @Relation(
        parentColumn = "epi_id",
        entityColumn = "cha_id",
        associateBy = Junction(CharacterEpisodeCrossRef::class)
    )
    val characters: List<Character>
)

data class CharacterWithEpisodes(
    @Embedded val character: Character,
    @Relation(
        parentColumn = "epi_id",
        entityColumn = "cha_id",
        associateBy = Junction(CharacterEpisodeCrossRef::class)
    )
    val episodes: List<Episode>
)