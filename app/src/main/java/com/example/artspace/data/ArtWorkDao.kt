package com.example.artspace.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ArtWorkDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(artWork: ArtWork)

    @Update
    suspend fun update(artWork: ArtWork)

    @Delete
    suspend fun delete(artWork: ArtWork)

    @Query("SELECT * from artWorks")
    fun getArtWorks(): Flow<List<ArtWork>>
}
