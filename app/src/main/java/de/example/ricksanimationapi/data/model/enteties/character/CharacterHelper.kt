package de.example.ricksanimationapi.data.model.enteties.character

import androidx.room.ColumnInfo
import androidx.room.Ignore
import com.squareup.moshi.Json

/**
 * Helping data class for [Character]
 */
data class ChaOrigin(
    @Json(name = "name") val cha_origin_name: String,
    @Json(name = "url") val cha_origin_url: String,
    @ColumnInfo(name = "cha_origin_id") val id: Int = extractIdFromLocationUrl(cha_origin_url)
)

/**
 * Helping data class for [Character.location]
 */
data class ChaLocation(
    @Json(name = "name") val cha_location_name: String,
    @Json(name = "url") val cha_location_url: String,
    var cha_location_id: Int = extractIdFromLocationUrl(cha_location_url)
)

data class CharacterResults(
    @Json(name = "info") var cha_info: CharacterInfo,
    @Json(name = "results") var cha_results: List<Character>
)

data class CharacterInfo(
    @Json(name = "count") val cha_count: Int,
    @Json(name = "pages") val cha_pages: Int,
    @Json(name = "next") val cha_next_page: String?,
    @Json(name = "prev") val cha_previous_page: String?
)
