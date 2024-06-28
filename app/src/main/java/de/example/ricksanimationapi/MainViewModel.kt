package de.example.ricksanimationapi

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import de.example.ricksanimationapi.data.Repository
import de.example.ricksanimationapi.data.local.RickDb.Companion.getRickDb
import de.example.ricksanimationapi.data.remote.RickApi
import de.example.ricksanimationapi.data.remote.ApiStatus
import kotlinx.coroutines.launch
import de.example.ricksanimationapi.data.model.enteties.character.Character

const val TAG = "MainViewModel"

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val rickDb = getRickDb(application)
    private val repository = Repository(RickApi, rickDb)

    private val _loading = MutableLiveData<ApiStatus>()
    val loading: LiveData<ApiStatus> get() = _loading

    val apiCounter = repository.apiCounter
    val characters = repository.characters

    private var _selectedCharacter = MutableLiveData<Character?>()
    val selectedCharacter: LiveData<Character?> get() = _selectedCharacter
    // TODO Überprüfen der Database

    fun loadInfo() {
        _loading.value = ApiStatus.INFO_LOADING
        viewModelScope.launch {
            try {
                repository.checkDb()
               _loading.value = ApiStatus.INFO_DONE
            } catch (e: Exception) {
                _loading.value = ApiStatus.INFO_ERROR
                Log.e(TAG, "Error loading Info: $e")
            }
        }
    }

    fun loadLocations() {
        _loading.value = ApiStatus.LOCATION_LOADING
        viewModelScope.launch {
            try {
                repository.loadLocations()
                _loading.value = ApiStatus.LOCATION_API_DONE
            } catch (e: Exception) {
                _loading.value = ApiStatus.LOCATION_API_ERROR
                Log.e(TAG, "Error loading Characters: $e")
                if (characters.value.isNullOrEmpty()) {
                    _loading.value = ApiStatus.LOCATION_DB_ERROR
                } else {
                    _loading.value = ApiStatus.LOCATION_DB_DONE
                }
            }
        }
    }

    fun setSelectedCharacter(character: Character) {
        _selectedCharacter.value = character
    }

    fun loadCharacters() {
        _loading.value = ApiStatus.CHARACTER_LOADING
        viewModelScope.launch {
            try {
                repository.loadCharacters()
                _loading.value = ApiStatus.CHARACTER_API_DONE
            } catch (e: Exception) {
                _loading.value = ApiStatus.CHARACTER_API_ERROR
                Log.e(TAG, "Error loading Characters: $e")
                if (characters.value.isNullOrEmpty()) {
                    _loading.value = ApiStatus.CHARACTER_DB_ERROR
                } else {
                    _loading.value = ApiStatus.CHARACTER_DB_DONE
                }
            }
        }
    }


}