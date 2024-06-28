package de.example.ricksanimationapi.data.model.enteties.character

import android.util.Log
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import de.example.ricksanimationapi.TAG
import java.net.URI

@Entity(tableName = "characters")
data class Character(

    @PrimaryKey
    @Json(name = "id") val chaId: Int,
    @Json(name = "name") val chaName: String,
    @Json(name = "status") val chaStatus: String,
    @Json(name = "species") val chaSpecies: String,
    @Json(name = "type") val chaType: String,
    @Json(name = "gender") val chaGender: String,
    @Json(name = "image") val chaImage: String,
    @Json(name = "url") val chaUrl: String,
    @Json(name = "created") val chaCreated: String,
    @Embedded @Json(name = "origin") val chaOrigin: ChaOrigin,
    @Embedded @Json(name = "location") val chaLocation: ChaLocation,
)

/**
 * @param url takes the Url of Character, Location or Episode
 * and extrect everything before the last / if their is no number
 *
 */
fun extractIdFromLocationUrl(url: String): Int {

    try {
        if (url != "") {
            val uri = URI(url)
            val path = uri.path
            val idStr = path.substring(path.lastIndexOf('/') + 1)
            val id = idStr.toInt()
            return id
        } else return 0
    } catch (e: Exception) {
        Log.e(TAG, "|| Could not extrect Id. Exception: $e")
        return 88888
    }
}



