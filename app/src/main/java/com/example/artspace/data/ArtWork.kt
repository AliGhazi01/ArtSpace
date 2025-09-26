package com.example.artspace.data

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "artWorks")
data class ArtWork(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String = "",
    val uri: Uri
)
