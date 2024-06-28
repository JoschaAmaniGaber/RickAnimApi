package de.example.ricksanimationapi.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import de.example.ricksanimationapi.data.local.RickDb
import de.example.ricksanimationapi.data.model.enteties.character.Character
import de.example.ricksanimationapi.data.model.enteties.character.CharacterInfo
import de.example.ricksanimationapi.data.model.enteties.character.CharacterResults
import de.example.ricksanimationapi.data.model.enteties.location.Location
import de.example.ricksanimationapi.data.model.enteties.location.LocationInfo
import de.example.ricksanimationapi.data.model.enteties.location.LocationResult
import de.example.ricksanimationapi.data.model.info.TableSizeCounter
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
    val characters: LiveData<List<Character>> get() = dao.getAllCharacters()
    //val character: LiveData<Character> get() = dao

    private val _apiCounter = MutableLiveData<TableSizeCounter>()
    val apiCounter: LiveData<TableSizeCounter> get() = _apiCounter

    suspend fun checkDb() {
        var page = 1
        var chaCount: Int = service.getCharacterPage(page).chaInfo.chaCount
        var loCount: Int = service.getLocationsPage(page).loInfo.loCount
        var epiCount: Int = service.getEpisodesPage(page).epiInfo.epiCount
        _apiCounter.postValue(TableSizeCounter(chaCount,loCount,epiCount))

    }

    // TODO suspend fun loadAnimations() {}

    suspend fun loadCharacters() {
        var page = 0
        try {
            withContext(Dispatchers.IO) {
                var chaResult: CharacterResults
                var chaInfo: CharacterInfo
                var characters: List<Character>
                var chaNextPage: String?
                do {
                    chaResult = service.getCharacterPage(++page)
                    chaInfo = chaResult.chaInfo
                    chaNextPage = chaInfo.chaNextPage
                    characters = chaResult.chaResults
                    dao.insertAllCharacter(characters)
                } while (chaNextPage != null)
                Log.e(TAG, "|| All Characters loaded to Database")
            }
        } catch (e: Exception) {
            Log.e(TAG, "|| Could not load characters page $page: $e")
        }
    }

    suspend fun loadLocations() {
        var page = 0
        try {
            withContext(Dispatchers.IO) {
                var loResult: LocationResult
                var loInfo: LocationInfo
                var locations: List<Location>
                var loNextPage: String?
                do {
                    loResult = service.getLocationsPage(++page)
                    loInfo = loResult.loInfo
                    loNextPage = loInfo.loNextPage
                    locations = loResult.loResults
                    dao.insertAllLocations(locations)
                } while (loNextPage != null)
                Log.e(TAG, "|| All Locations loaded to Database")
            }
        } catch (e: Exception) {
            Log.e(TAG, "|| Could not load locations at page: $page : $e")
        }
    }


    /**
    private val _charactersCount = MutableLiveData<Int>()
    val charactersCount: LiveData<Int> get() = _charactersCount

    private val _locationCount = MutableLiveData<Int>()
    val locationsCount: LiveData<Int> get() = _locationCount

    private val _episodesCount = MutableLiveData<Int>()
    val episodesCount: LiveData<Int> get() = _episodesCount
     */

}