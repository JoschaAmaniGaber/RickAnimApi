package de.example.ricksanimationapi.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import de.example.ricksanimationapi.data.model.enteties.episode.Episode
import com.example.rickandmortyguide.data.model.location.Location
import com.example.rickandmortyguide.data.model.location.LocationWithCharacters
import de.example.ricksanimationapi.data.model.enteties.character.Character
import de.example.ricksanimationapi.data.model.enteties.crossref.CharacterEpisodeCrossRef

@Dao
interface RickDbDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(character: Character)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocation(location: Location)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEpisode(episode: Episode)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacterEpisodeCrossRef(characterEpisodeCrossRef: CharacterEpisodeCrossRef)

    @Transaction
    @Query("select * from locations where lo_name = :lo_name")
    suspend fun getLocationWithCharacters(lo_name: String): List<LocationWithCharacters>

    @Transaction
    @Query("select * from characters")
    fun getAllCharacters(): LiveData<List<Character>>

    @Transaction
    @Query("select * from episodes")
    fun getAllEpisodes(): LiveData<List<Episode>>

    @Transaction
    @Query("select * from locations")
    fun getAllLocations(): LiveData<List<Location>>

    @Query("delete from characters")
    suspend fun deleteAllCharacters()

    @Query("delete from locations")
    suspend fun deleteAllLocations()

    @Query("delete from episodes")
    suspend fun deleteAllEpisodes()


}