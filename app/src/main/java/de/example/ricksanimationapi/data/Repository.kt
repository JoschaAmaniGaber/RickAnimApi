package de.example.ricksanimationapi.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import de.example.ricksanimationapi.data.local.RickDb
import de.example.ricksanimationapi.data.model.api.CharacterFromApi
import de.example.ricksanimationapi.data.model.enteties.CharacterEntity
import de.example.ricksanimationapi.data.model.enteties.extractIdFromLocationUrl
import de.example.ricksanimationapi.data.remote.RickApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private const val TAG = "Repository"

class Repository(
    private val service: RickApi,
    private val rickDb: RickDb
) {

    private val _charactersCount = MutableLiveData<Int>()
    val charactersCount: LiveData<Int> get() = _charactersCount

    private val _locationCount = MutableLiveData<Int>()
    val locationsCount: LiveData<Int> get() = _locationCount

    private val _episodesCount = MutableLiveData<Int>()
    val episodesCount: LiveData<Int> get() = _episodesCount

    val characters: LiveData<List<CharacterEntity>> get() = rickDb.dao.getAllCharacters()

    suspend fun loadInfo() {
        _charactersCount.postValue(service.retrofitService.getCharactersInfo().characterInfo.count)
        _locationCount.postValue(service.retrofitService.getLocationsInfo().locationInfo.count)
        _episodesCount.postValue(service.retrofitService.getEpisodesInfo().episodeInfo.count)
    }

    suspend fun loadCharacters() {
        var id = 0
        var count: Int = service.retrofitService.getCharactersInfo().characterInfo.count
        try {
            withContext(Dispatchers.IO) {
                var characterFromApi: CharacterFromApi
                var characterEntity: CharacterEntity
                do {
                    characterFromApi = service.retrofitService.getCharacterById(++id)
                    characterEntity =
                        CharacterEntity(
                            characterFromApi.id,
                            characterFromApi.name,
                            characterFromApi.status,
                            characterFromApi.species,
                            characterFromApi.type,
                            characterFromApi.gender,
                            characterFromApi.origin.name,
                            extractIdFromLocationUrl(characterFromApi.location.url),
                            characterFromApi.image,
                            characterFromApi.url,
                            characterFromApi.created
                        )
                    rickDb.dao.insertCharacter(characterEntity)

                } while (id < count+1)
            }
        } catch (e: Exception) {
            Log.e(TAG, "Could not load character id $id: $e")
        }
    }

}