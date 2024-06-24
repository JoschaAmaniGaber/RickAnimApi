package de.example.ricksanimationapi.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import de.example.ricksanimationapi.data.model.enteties.CharacterEntity
import de.example.ricksanimationapi.data.model.enteties.CharacterEpisodeCrossRef
import de.example.ricksanimationapi.data.model.enteties.EpisodeEntity
import de.example.ricksanimationapi.data.model.enteties.LocationEntity

@Dao
interface RickDbDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(characterEntity: CharacterEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocation(locationEntity: LocationEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEpisode(episodeEntity: EpisodeEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacterEpisodeCrossRef(characterEpisodeCrossRef: CharacterEpisodeCrossRef)

    @Query("select * from characters")
    fun getAllCharacters(): LiveData<List<CharacterEntity>>

    @Query("select * from episodes")
    fun getAllEpisodes(): LiveData<List<EpisodeEntity>>

    @Query("select * from locations")
    fun getAllLocations(): LiveData<List<LocationEntity>>

    @Query("delete from characters")
    suspend fun deleteAllCharacters()

    @Query("delete from locations")
    suspend fun deleteAllLocations()

    @Query("delete from episodes")
    suspend fun deleteAllEpisodes()


}