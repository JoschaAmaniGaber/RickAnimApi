package de.example.ricksanimationapi.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import de.example.ricksanimationapi.data.model.enteties.CharacterEntity
import de.example.ricksanimationapi.data.model.enteties.CharacterEpisodeCrossRef
import de.example.ricksanimationapi.data.model.enteties.EpisodeEntity
import de.example.ricksanimationapi.data.model.enteties.LocationEntity

@Database(
    entities = [
        CharacterEntity::class,
        LocationEntity::class,
        EpisodeEntity::class,
        CharacterEpisodeCrossRef::class
    ],
    version = 1
)
abstract class RickDb : RoomDatabase() {

    abstract val dao: RickDbDao
}

private lateinit var INSTANCE: RickDb

fun getRickDb(context: Context) : RickDb {

    synchronized(RickDb::class.java) {

        if (!::INSTANCE.isInitialized) {

            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                RickDb::class.java,
                "rick_db"
            ).build()
        }
        return INSTANCE
    }
}