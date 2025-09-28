package com.example.artspace.data

import kotlinx.coroutines.flow.Flow

class ArtWorkRepository(private val artWorkDao: ArtWorkDao) {
    fun getArtWorksStream(): Flow<List<ArtWork>> = artWorkDao.getArtWorks()

    suspend fun insertArtWork(artWork: ArtWork) = artWorkDao.insert(artWork)

    suspend fun deleteArtWork(artWork: ArtWork) = artWorkDao.delete(artWork)

    suspend fun updateArtWork(artWork: ArtWork) = artWorkDao.update(artWork)
}