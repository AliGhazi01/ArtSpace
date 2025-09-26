package com.example.artspace

import android.app.Application
import com.example.artspace.data.AppContainer
import com.example.artspace.data.AppDataContainer

class ArtSpaceApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}