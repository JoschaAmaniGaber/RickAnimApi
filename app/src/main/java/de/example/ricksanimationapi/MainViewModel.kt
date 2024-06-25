package de.example.ricksanimationapi

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import de.example.ricksanimationapi.data.Repository
import de.example.ricksanimationapi.data.local.RickDb.Companion.getRickDb
import de.example.ricksanimationapi.data.remote.RickApi
import de.example.ricksanimationapi.data.remote.ApiStatusCharacter
import kotlinx.coroutines.launch

const val TAG = "MainViewModel"

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val rickDb = getRickDb(application)
    private val repository = Repository(RickApi, rickDb)

    private val _loading = MutableLiveData<ApiStatusCharacter>()
   // val loading: LiveData<ApiStatusCharacter> get() = _loading

    val characters = repository.characters

    // TODO Überprüfen der Database

    //fun checkDb() {}

    fun loadCharacters() {
        _loading.value = ApiStatusCharacter.LOADING
        viewModelScope.launch {
            try {
                repository.loadCharacters()
                _loading.value = ApiStatusCharacter.API_DONE
            } catch (e: Exception) {
                Log.e(TAG, "Error loading Characters: $e")
                if (characters.value.isNullOrEmpty()) {
                    _loading.value = ApiStatusCharacter.DB_ERROR
                } else {
                    _loading.value = ApiStatusCharacter.API_ERROR
                }
            }
        }
    }
}