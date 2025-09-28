package com.example.artspace.ui

import android.app.Application
import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.example.artspace.ArtSpaceApplication
import com.example.artspace.data.ArtWork
import kotlinx.coroutines.flow.Flow

class ArtWorkViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = (application as ArtSpaceApplication).container.artWorkRepository

    val artWorks: Flow<List<ArtWork>> = repository.getArtWorksStream()

    var selectedArtWork by mutableStateOf<ArtWork>(ArtWork(0, "", null))

    var updatedTitle by mutableStateOf("")

    fun updateArtWorkTitle() {
        selectedArtWork.title = updatedTitle
    }
    suspend fun addArtWork(uri: Uri) {
        repository.insertArtWork(ArtWork(uri = uri))
    }

    suspend fun updateArtWork(artWork: ArtWork) {
        repository.updateArtWork(artWork)
    }

    fun selectArtWork(artWork: ArtWork) {
        selectedArtWork = artWork
        updatedTitle = artWork.title
    }
}
