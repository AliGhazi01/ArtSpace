package com.example.artspace.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.artspace.data.ArtPiece
import com.example.artspace.data.Routes

@Composable
fun ArtPieceCard(
    artPiece: ArtPiece,
    artViewModel: ArtViewModel,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Card(
        modifier = Modifier.Companion
            .fillMaxWidth()
            .padding(vertical = 50.dp)
            .clickable {
                artViewModel.selectArtPiece(artPiece)
                navController.navigate(Routes.EDIT)
            },
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Companion.White),
        elevation = CardDefaults.cardElevation(8.dp)
    )
    {
        Column(
            modifier = Modifier.Companion.fillMaxWidth()
                .padding(5.dp),
            horizontalAlignment = Alignment.Companion.CenterHorizontally
        ) {
            Image(
                painter = painterResource(artPiece.imageResId),
                contentDescription = null,
                contentScale = ContentScale.Companion.Crop,
                modifier = Modifier.Companion.fillMaxWidth()
            )
            Text(
                text = artPiece.title ?: "",
                color = Color.Companion.Black,
                modifier = Modifier.Companion.padding(top = 10.dp),
                fontSize = 24.sp,
                fontStyle = FontStyle.Companion.Italic
            )
        }
    }
}