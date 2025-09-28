package com.example.artspace

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.artspace.data.Routes
import com.example.artspace.ui.ArtViewModel
import com.example.artspace.ui.ArtWorkViewModel
import com.example.artspace.ui.EditScreen
import com.example.artspace.ui.HomeScreen
import com.example.artspace.ui.theme.ArtSpaceTheme
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtSpaceLayout(
    modifier: Modifier = Modifier,
    artWorkViewModel: ArtWorkViewModel = viewModel(),
    navController : NavHostController = rememberNavController()
) {
    val context = LocalContext.current

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val currentRoute = navBackStackEntry?.destination?.route

    // State to hold the selected image URI
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }

    val coroutineScope = rememberCoroutineScope()
    // Launcher for picking an image
    val pickImageLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument()
    ) { uri: Uri? ->
        uri?.let {
            try {
                context.contentResolver.takePersistableUriPermission(
                    it,
                    Intent.FLAG_GRANT_READ_URI_PERMISSION
                )
            } catch (e: SecurityException) {
                e.printStackTrace()
            }

            coroutineScope.launch {
                artWorkViewModel.addArtWork(uri)
            }
        }
    }

    Scaffold(
        topBar = {
            when (currentRoute) {
                Routes.HOME -> {
                    TopAppBar(
                        colors = topAppBarColors(
                            containerColor = Color(0xff3f312f),
                            titleContentColor = Color.White,
                            actionIconContentColor = Color.White
                        ),
                        title = { Text("ArtSpace") },
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
                                    pickImageLauncher.launch(arrayOf("image/*"))
                                }
                            ) {
                                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
                            }
                        }
                    )
                }
                Routes.EDIT -> {
                    TopAppBar(
                        colors = topAppBarColors(
                            containerColor = Color(0xff3f312f),
                            titleContentColor = Color.White,
                            actionIconContentColor = Color.White,
                            navigationIconContentColor = Color.White
                        ),
                        title = { Text("ArtSpace") },
                        navigationIcon = {
                            IconButton(onClick = { navController.popBackStack() }) {
                                Icon(
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = "Back"
                                )
                            }
                        },
                        actions = {
                            IconButton(
                                onClick = {
                                    artWorkViewModel.updateArtWorkTitle()
                                    coroutineScope.launch {
                                        artWorkViewModel.updateArtWork(artWorkViewModel.selectedArtWork)
                                    }
                                    navController.popBackStack()
                                }
                            ) {
                                Icon(imageVector = Icons.Default.Check, contentDescription = "Save")
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = Routes.HOME,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(route = Routes.HOME) {
                HomeScreen(navController = navController, artWorkViewModel = artWorkViewModel)
            }
            composable(route = Routes.EDIT) {
                EditScreen(artWorkViewModel = artWorkViewModel)
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun ArtSpaceLayoutPreview() {
    ArtSpaceTheme {
    }
}