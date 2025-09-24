package com.example.artspace.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "artWorks")
data class ArtWork(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val uri: String
)
