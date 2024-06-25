package de.example.ricksanimationapi.data.remote

import de.example.ricksanimationapi.data.model.enteties.episode.Episode
import com.example.rickandmortyguide.data.model.location.Location
import com.example.rickandmortyguide.data.model.location.LocationResult
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import de.example.ricksanimationapi.data.model.enteties.character.Character
import de.example.ricksanimationapi.data.model.enteties.character.CharacterResults
import de.example.ricksanimationapi.data.model.enteties.episode.EpisodeResults
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val BASE_URL = "https://rickandmortyapi.com/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()
interface RickApiService {

    @GET("character")
    suspend fun getCharactersInfo(): CharacterResults

    @GET("location")
    suspend fun getLocationsInfo(): LocationResult

    @GET("episode")
    suspend fun getEpisodesInfo(): EpisodeResults

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): Character

    @GET("location/{id}")
    suspend fun getLocationById(@Path("id") id: Int): Location

    @GET("episode/{id}")
    suspend fun getEpisodeById(@Path("id") id: Int): Episode

}

object RickApi {
    val retrofitService: RickApiService by lazy { retrofit.create(RickApiService::class.java) }
}