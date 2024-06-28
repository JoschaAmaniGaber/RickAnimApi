package de.example.ricksanimationapi.data.model.enteties.user

import android.graphics.Color

//@Entity(tableName = "users")
data class User(
    //@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "profile_id") val id: UUID,
    val name: String,
    val age: Int?,

    //@Embedded val userProfile: UserProfile,

)

data class UserProfile(
    val userProfilName: String,
    val animMode: Boolean,
    val colorMode: Boolean,
    val textColor: Color
)