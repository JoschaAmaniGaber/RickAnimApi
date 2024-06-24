package de.example.ricksanimationapi.data.model.enteties.relations

import androidx.room.Embedded
import androidx.room.Relation
import de.example.ricksanimationapi.data.model.enteties.CharacterEntity
import de.example.ricksanimationapi.data.model.enteties.LocationEntity

data class LocationWithCharacters(
    @Embedded val locationEntity: LocationEntity,
    @Relation(
        parentColumn = "location_id",
        entityColumn = "character_location_id"
    )
    val characters: List<CharacterEntity>
)
