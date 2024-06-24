package de.example.ricksanimationapi.data.model.enteties

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "locations")
data class LocationEntity(
    @PrimaryKey
    val location_id: Int,
    val location_name: String,
    val location_type: String,
    val location_dimension: String,
    val location_url: String,
    val location_created: String,

//    @Ignore val residents: List<String>,
)
