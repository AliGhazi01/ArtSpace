package com.example.artspace.ui

import android.R.attr.label
import android.R.attr.singleLine
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ArtSpaceLayout
import com.example.artspace.R
import com.example.artspace.data.ArtPiece
import com.example.artspace.ui.theme.ArtSpaceTheme

@Composable
fun EditScreen(artViewModel: ArtViewModel) {
    val artPiece = artViewModel.selectedArtPiece
    var title by remember { mutableStateOf(artPiece?.title ?: "") }
    Column(
        modifier = Modifier.Companion.fillMaxWidth()
            .padding(5.dp),
        horizontalAlignment = Alignment.Companion.CenterHorizontally
    ) {
        Image(
            painter = painterResource(artPiece!!.imageResId),
            contentDescription = null,
            contentScale = ContentScale.Companion.Crop,
            modifier = Modifier.Companion.fillMaxWidth()
                .clip(RoundedCornerShape(4.dp))
        )
        OutlinedTextField(
            value = title,
            onValueChange = {
                title = it
                artViewModel.updateTitle(title)
                            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Title") }
        )

    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceLayoutPreview() {
    ArtSpaceTheme {
//        EditScreen()
    }
}