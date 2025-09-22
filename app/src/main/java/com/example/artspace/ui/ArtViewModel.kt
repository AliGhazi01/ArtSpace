package com.example.artspace.ui

import androidx.annotation.DrawableRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.artspace.data.ArtPiece

class  ArtViewModel : ViewModel() {
    var selectedArtPiece by mutableStateOf<ArtPiece?>(null)
        private set

    fun selectArtPiece(artPiece: ArtPiece) {
        selectedArtPiece = artPiece
    }

    fun updateTitle(newTitle: String) {
        selectedArtPiece = selectedArtPiece?.copy(title = newTitle)
    }

    fun clearSelection() {
        selectedArtPiece = null
    }
}