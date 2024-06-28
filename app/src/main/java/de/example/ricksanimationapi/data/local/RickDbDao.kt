package de.example.ricksanimationapi.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import de.example.ricksanimationapi.data.model.enteties.episode.Episode
import de.example.ricksanimationapi.data.model.enteties.character.Character
import de.example.ricksanimationapi.data.model.enteties.crossref.CharacterEpisodeCrossRef
import de.example.ricksanimationapi.data.model.enteties.location.Location
import de.example.ricksanimationapi.data.model.enteties.location.LocationWithCharacters

@Dao
interface RickDbDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCharacter(characters: List<Character>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllLocations(locations: List<Location>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllEpisodes(episodes: List<Episode>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacterEpisodeCrossRef(characterEpisodeCrossRef: CharacterEpisodeCrossRef)

    @Transaction
    @Query("select * from locations where loId = :loId")
    suspend fun getLocationWithCharacters(loId: Int): List<LocationWithCharacters>

    @Transaction
    @Query("select * from characters")
    fun getAllCharacters(): LiveData<List<Character>>


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