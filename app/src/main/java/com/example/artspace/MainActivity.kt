package com.example.artspace

import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collection.mutableVectorOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                    ArtSpaceLayoutPreview()
                }
            }
        }
}

data class Painting(
    val painter : Int,
    val title: String?,
    val description : String?
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtSpaceLayout(modifier: Modifier = Modifier) {
    var listIndex  by remember { mutableStateOf(0) }
    val paintings = listOf(
        Painting(R.drawable.psyduck, "Psyduck Psychedelia" ,null),
        Painting(R.drawable.lonely_pikachu, "Pikachu Peace" ,null),
        Painting(R.drawable.butterfree_melancholy, "Butterfree Melancholy" ,null)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Color(0xff3f312f),
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White
                ),
                title = { Text("ArtSpace")},
                actions = {
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                    }
                    VerticalDivider(
                        modifier = Modifier.height(24.dp),
                        color = Color.White
                    )
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
                    }
                }
            )
        }
    ) { paddingValues ->

        Box(
            modifier = Modifier.fillMaxSize().background(colorResource(R.color.content_Background)).padding(paddingValues),
            contentAlignment = Alignment.Center,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            )
            {
                Button(
                    onClick = {
                        if (listIndex == 0) listIndex = paintings.size - 1 else listIndex--
                    },
                    modifier = Modifier.fillMaxHeight()
                        .width(80.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                ) { Text("") }

                Button(
                    onClick = {
                        if (listIndex == paintings.size - 1) listIndex = 0 else listIndex++
                    },
                    modifier = Modifier.fillMaxHeight()
                        .width(80.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                ) { Text("") }
            }
            Column(
                modifier = Modifier
                    .shadow(elevation = 8.dp, clip = true)
                    .background(Color.White)
                    .padding(20.dp)
            ) {
                Image(
                    modifier = Modifier,
                    painter = painterResource(paintings[listIndex].painter),
                    contentDescription = ""
                )
                Text(
                    text = if (paintings[listIndex].title != null)
                        "\"${paintings[listIndex].title!!}\"" else "",
                    modifier = Modifier.padding(top = 10.dp),
                    fontSize = 24.sp,
                    fontStyle = FontStyle.Italic
                )
                Text(
                    text = paintings[listIndex].description ?: ""
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceLayoutPreview() {
    ArtSpaceTheme {
        ArtSpaceLayout()
    }
}