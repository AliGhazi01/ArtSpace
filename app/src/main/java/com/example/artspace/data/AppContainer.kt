package com.example.artspace.data

import android.content.Context
import androidx.room.Database

interface AppContainer {
    val artWorkRepository: ArtWorkRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val artWorkRepository: ArtWorkRepository by lazy {
        ArtWorkRepository(
            ArtWorkDatabase.getDatabase(context).artWorkDao()
        )
    }

}


