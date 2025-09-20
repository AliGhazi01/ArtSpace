package com.example.artspace

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
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.artspace.data.Routes
import com.example.artspace.ui.EditScreen
import com.example.artspace.ui.HomeScreen
import com.example.artspace.ui.theme.ArtSpaceTheme



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtSpaceLayout(
    modifier: Modifier = Modifier,
    navController : NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

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
                                onClick = {}
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
                HomeScreen(navController = navController)
            }
            composable(route = Routes.EDIT) {
                EditScreen()
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun ArtSpaceLayoutPreview() {
    ArtSpaceTheme {
        ArtSpaceLayout()
//        EditScreen()
    }
}