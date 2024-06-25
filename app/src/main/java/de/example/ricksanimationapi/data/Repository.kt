package de.example.ricksanimationapi.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rickandmortyguide.data.model.location.Location
import de.example.ricksanimationapi.data.local.RickDb
import de.example.ricksanimationapi.data.model.enteties.character.Character
import de.example.ricksanimationapi.data.remote.RickApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private const val TAG = "Repository"

class Repository(
    rickApi: RickApi,
    rickDb: RickDb
) {

    private var service = rickApi.retrofitService
    private val dao = rickDb.dao

    private val _charactersCount = MutableLiveData<Int>()
    val charactersCount: LiveData<Int> get() = _charactersCount

    private val _locationCount = MutableLiveData<Int>()
    val locationsCount: LiveData<Int> get() = _locationCount

    private val _episodesCount = MutableLiveData<Int>()
    val episodesCount: LiveData<Int> get() = _episodesCount

    val characters: LiveData<List<Character>> get() = dao.getAllCharacters()

    suspend fun checkDb() {
        _charactersCount.postValue(service.getCharactersInfo().cha_info.cha_count)
        _locationCount.postValue(service.getLocationsInfo().lo_info.lo_count)
        _episodesCount.postValue(service.getEpisodesInfo().epi_info.epi_count)
    }

    suspend fun loadCharacters() {
        var id = 0
        var count: Int = service.getCharactersInfo().cha_info.cha_count
        try {
            withContext(Dispatchers.IO) {
                var character: Character
                do {
                    character = service.getCharacterById(++id)
                    dao.insertCharacter(character)

                } while (id < count+1)
            }
        } catch (e: Exception) {
            Log.e(TAG, "Could not load character id $id: $e")
        }
    }

    suspend fun loadLocations() {
        var id = 0
        var count: Int = service.getLocationsInfo().lo_info.lo_count
        try {
            withContext(Dispatchers.IO) {
                var location: Location
                do {
                    location = service.getLocationById(++id)
                    dao.insertLocation(location)

                } while (id < count+1)
            }
        } catch (e: Exception) {
            Log.e(TAG, "Could not load character id $id: $e")
        }
    }



}