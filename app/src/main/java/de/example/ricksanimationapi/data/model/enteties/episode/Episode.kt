package de.example.ricksanimationapi.data.model.enteties.episode

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "episodes")
data class Episode(

    @PrimaryKey
    @Json(name = "id") val epi_id: Int,

    @Json(name = "name") val epi_name: String,
    @Json(name = "air_date") val epi_air_date: String,
    @Json(name = "url") val epi_url: String,
    @Json(name = "created")val epi_created: String,

    /**
     * TODO val epi_characters: List<String>, crossref m to n
     */

)

data class EpisodeResults(
    @Json(name = "info") val epi_info: EpisodeInfo,
    @Json(name = "results") val epi_results: List<Episode>
)


data class EpisodeInfo(
    @Json(name = "count") val epi_count: Int,
    @Json(name = "pages") val epi_pages: Int,
    @Json(name = "next") val epi_nextPage: String?,
    @Json(name = "prev") val epi_previousPage: String?
)
