package de.example.ricksanimationapi

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import de.example.ricksanimationapi.data.Repository
import de.example.ricksanimationapi.data.local.getRickDb
import de.example.ricksanimationapi.data.remote.ApiStatus
import de.example.ricksanimationapi.data.remote.RickApi
import kotlinx.coroutines.launch

const val TAG = "MainViewModel"

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val rickDb = getRickDb(application)
    private val repository = Repository(RickApi, rickDb)

    private val _loading = MutableLiveData<ApiStatus>()
    val loading: LiveData<ApiStatus> get() = _loading

    val characters = repository.characters

    fun loadCharacters() {
        viewModelScope.launch {
            try {
                repository.loadCharacters()
                _loading.value = ApiStatus.CHARACTERSDONE
            } catch (e: Exception) {
                Log.e(TAG, "Error loading Characters: $e")
                if (characters.value.isNullOrEmpty()) {
                    _loading.value = ApiStatus.ERROR
                } else {
                    _loading.value = ApiStatus.CHARACTERSDONE
                }
            }
        }
    }
}