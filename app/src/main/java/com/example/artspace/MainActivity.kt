package com.example.artspace

//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.artspace.ui.ArtSpaceLayoutPreview
import com.example.artspace.ui.ArtViewModel
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                    ArtSpaceLayout()
                }
            }
        }
}

