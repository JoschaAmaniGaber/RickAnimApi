package de.example.ricksanimationapi.data.model.api

data class CharacterFromApi(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val image: String,
    val url: String,
    val created: String,
    val origin: Origin,
    val location: Origin,
)


