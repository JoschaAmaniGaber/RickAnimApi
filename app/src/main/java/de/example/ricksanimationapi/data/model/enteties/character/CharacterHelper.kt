package de.example.ricksanimationapi.data.model.enteties.character

import androidx.room.ColumnInfo
import com.squareup.moshi.Json
import de.example.ricksanimationapi.data.model.enteties.location.Location

/**
 * Helping data class for [Character]
 * @param chaOriginName Origin Name
 * @param chaOriginUrl the Url for a possible Api Call but we use it, to get
 * @param chaOriginId for getting the id we use the Url for [extractIdFromLocationUrl]
 * with that Id we will be able to databinding with [Location.loCharacters]
 */
data class ChaOrigin(
    @Json(name = "name") val chaOriginName: String,
    @Json(name = "url") val chaOriginUrl: String,
    @ColumnInfo(name = "chaOriginId") val chaOriginId: Int = extractIdFromLocationUrl(chaOriginUrl)
)

/**
 * Helping data class for [Character]
 *  @param chaLocationName Location Name
 *  @param chaLocationUrl the Url for a possible Api Call but we use it, to get
 *  @param chaLocationId for getting the id we use the Url for [extractIdFromLocationUrl]
 *  with that Id we will be able to databinding with [Location.loCharacters]
 */
data class ChaLocation(
    @Json(name = "name") val chaLocationName: String,
    @Json(name = "url") val chaLocationUrl: String,
    var chaLocationId: Int = extractIdFromLocationUrl(chaLocationUrl)
)

data class CharacterResults(
    @Json(name = "info") var chaInfo: CharacterInfo,
    @Json(name = "results") var chaResults: List<Character>
)

data class CharacterInfo(
    @Json(name = "count") val chaCount: Int,
    @Json(name = "pages") val chaPages: Int,
    @Json(name = "next") val chaNextPage: String?,
    @Json(name = "prev") val chaPreviousPage: String?
)
