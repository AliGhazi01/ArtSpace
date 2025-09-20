package com.example.artspace.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.artspace.R
import com.example.artspace.data.ArtPiece

@Composable
fun HomeScreen(navController: NavHostController, artViewModel: ArtViewModel = viewModel()) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.content_Background)),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(0.9f)
        ) {
            items(
                listOf(
                    ArtPiece(R.drawable.psyduck, "Psyduck Psychedelia" ),
                    ArtPiece(R.drawable.lonely_pikachu, "Pikachu Peace"),
                    ArtPiece(R.drawable.butterfree_melancholy, "Butterfree Melancholy" )
                )
            ) { artPiece ->
                ArtPieceCard(
                    artPiece = artPiece,
                    artViewModel = artViewModel,
                    modifier = Modifier,
                    navController
                )
            }
        }
    }
}