package com.example.artspace.ui

import android.R.attr.contentDescription
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.artspace.R
import com.example.artspace.data.ArtWork
import com.example.artspace.data.Routes

@Composable
fun ArtWorkCard(
    artWork: ArtWork,
    artWorkViewModel: ArtWorkViewModel,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Card(
        modifier = Modifier.Companion
            .fillMaxWidth()
            .padding(vertical = 50.dp)
            .clickable {
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
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(artWork.uri  )
                    .listener(
                        onStart = { request ->
                            Log.d("CoilDebug", "Image loading started: ${request.data}")
                        },
                        onSuccess = { request, result ->
                            Log.d("CoilDebug", "Image loading success: ${request.data}")
                        },
                        onError = { request, error ->
                            Log.e("CoilDebug", "Image loading error for ${request.data}: ${error.throwable.message}", error.throwable)
                        }
                    )
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Companion.Crop,
                modifier = Modifier.Companion.fillMaxWidth(),
                error = painterResource(R.drawable.psyduck)
            )
            Text(
                text = artWork.title,
                color = Color.Companion.Black,
                modifier = Modifier.Companion.padding(top = 10.dp),
                fontSize = 24.sp,
                fontStyle = FontStyle.Companion.Italic
            )
        }
    }
}