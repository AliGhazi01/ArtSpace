package com.example.artspace.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kotlin.jvm.java

@Database(entities = [ArtWork::class], version = 2, exportSchema = false)
@TypeConverters(UriConverter::class)
abstract class ArtWorkDatabase() : RoomDatabase() {
    abstract fun artWorkDao(): ArtWorkDao
    companion object {
        @Volatile
        private var Instance : ArtWorkDatabase? = null

        fun getDatabase(context: Context): ArtWorkDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, ArtWorkDatabase::class.java, "artwork_database")
                    .fallbackToDestructiveMigration()
                    .build().also{ Instance = it }
            }
        }

    }
}
