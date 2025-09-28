package com.example.artspace.ui

import android.app.Application
import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.example.artspace.data.ArtWorkRepository
import androidx.lifecycle.ViewModel
import com.example.artspace.ArtSpaceApplication
import com.example.artspace.data.AppContainer
import com.example.artspace.data.AppDataContainer
import com.example.artspace.data.ArtWork
import kotlinx.coroutines.flow.Flow

class ArtWorkViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = (application as ArtSpaceApplication).container.artWorkRepository

    val artWorks: Flow<List<ArtWork>> = repository.getArtWorksStream()

    var selectedArtWork by mutableStateOf<ArtWork?>(null)

    suspend fun addArtWork(uri: Uri) {
        repository.insertArtWork(ArtWork(uri = uri))
    }

    fun selectArtWork(artWork: ArtWork) {
        selectedArtWork = artWork
    }
}
