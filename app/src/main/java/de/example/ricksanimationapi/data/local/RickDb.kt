package de.example.ricksanimationapi.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import de.example.ricksanimationapi.data.model.enteties.episode.Episode
import de.example.ricksanimationapi.data.model.enteties.location.Location
import de.example.ricksanimationapi.data.model.enteties.character.Character
import de.example.ricksanimationapi.data.model.enteties.crossref.CharacterEpisodeCrossRef

@Database(
    version = 1,
    entities = [
        Character::class,
        Location::class,
        Episode::class,
        CharacterEpisodeCrossRef::class
    ]
)
abstract class RickDb : RoomDatabase() {

    abstract val dao: RickDbDao

    companion object {
        @Volatile
        private var INSTANCE: RickDb? = null

        fun getRickDb(context: Context) : RickDb {

            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    RickDb::class.java,
                    "rick_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}

