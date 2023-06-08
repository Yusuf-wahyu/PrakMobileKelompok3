package id.ac.unpas.perkuliahan.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import id.ac.unpas.perkuliahan.screens.dosen.FormPencatatanDosenScreen
import id.ac.unpas.perkuliahan.ui.theme.Purple700
import kotlinx.coroutines.launch
import id.ac.unpas.perkuliahan.screens.dosen.PengelolaanDosenScreen
import id.ac.unpas.perkuliahan.screens.mahasiswa.FormPencatatanMahasiswaScreen
import id.ac.unpas.perkuliahan.screens.mahasiswa.PengelolaanMahasiswaScreen
import id.ac.unpas.perkuliahan.screens.matakuliah.FormPencatatanMatakuliahScreen
import id.ac.unpas.perkuliahan.screens.matakuliah.PengelolaanMatakuliahScreen

@Composable
fun MainScreen() {
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val title = remember { mutableStateOf("") }
    val appBarHorizontalPadding = 4.dp
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Purple700,
                elevation = 0.dp,
                modifier= Modifier.fillMaxWidth()) {
                //TopAppBar Content
                Box(Modifier.height(32.dp)) {
                    Row(
                        Modifier
                            .fillMaxHeight()
                            .width(72.dp -
                                    appBarHorizontalPadding), verticalAlignment =
                        Alignment.CenterVertically) {
                        CompositionLocalProvider(
                            LocalContentAlpha provides
                                    ContentAlpha.high,
                        ) {
                            IconButton(
                                onClick = { },
                                enabled = true,
                            ) {
                                Icon(Icons.Filled.Menu, null,
                                    tint = Color.White)
                            }
                        }
                    }
                    //Title
                    Row(Modifier.fillMaxSize(),
                        verticalAlignment =
                        Alignment.CenterVertically) {
                        ProvideTextStyle(value =
                        MaterialTheme.typography.h6) {
                            CompositionLocalProvider(
                                LocalContentAlpha provides
                                        ContentAlpha.high,
                            ){
                                Text(
                                    modifier =
                                    Modifier.fillMaxWidth(),
                                    textAlign =
                                    TextAlign.Center,
                                    color = Color.White,
                                    maxLines = 1,
                                    text = title.value
                                )
                            }
                        }
                    }
                }
            }
        },
        scaffoldState = scaffoldState,
        snackbarHost = {
                    SnackbarHost(it) { data ->
                        // custom snackbar with the custom colors
                        Snackbar(
                            actionColor = Color.Green,
                            contentColor = Color.White,
                            snackbarData = data
                        )
                    }
        },
        drawerContent = {
            DrawerContent { route ->
                navController.navigate(route)
                scope.launch {scaffoldState.drawerState.close()
                }
            }
        },
        bottomBar = {
            BottomNavigationComposable(title.value, onClick =
            { tab ->
                navController.navigate(tab.route)
            })
        },
    )
    { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavHost(navController = navController,
                startDestination = "home") {
                composable("home") {
                    HomeScreen()
                }
                composable("setting") {
                    SettingScreen()
                }
                composable("pengelolaan-dosen") {
                    title.value = "Pengelolaan Dosen"
                    PengelolaanDosenScreen(navController =
                    navController, snackbarHostState =
                    scaffoldState.snackbarHostState, modifier =
                    Modifier.padding(innerPadding))
                }
                composable("tambah-pengelolaan-dosen") {
                    title.value = "Tambah Pengelolaan Dosen"
                    FormPencatatanDosenScreen(navController =
                    navController, modifier = Modifier.padding(innerPadding))
                }
                composable("edit-pengelolaan-dosen/{id}",
                    listOf(
                        navArgument("id") {
                            type = NavType.StringType
                        }
                    )) { backStackEntry ->
                    title.value = "Edit Pengelolaan Dosen"
                    val id = backStackEntry.arguments?.getString("id")
                        ?: return@composable
                    FormPencatatanDosenScreen(navController =
                    navController, id = id, modifier =
                    Modifier.padding(innerPadding))
                }

                //Mahasiswa
                composable("pengelolaan-mahasiswa") {
                    title.value = "Pengelolaan Mahasiswa"
                    PengelolaanMahasiswaScreen(navController =
                    navController, snackbarHostState =
                    scaffoldState.snackbarHostState, modifier =
                    Modifier.padding(innerPadding))
                }

                composable("tambah-pengelolaan-mahasiswa") {
                    title.value = "Tambah Pengelolaan Mahasiswa"
                    FormPencatatanMahasiswaScreen(navController =
                    navController, modifier = Modifier.padding(innerPadding))
                }

                composable("edit-pengelolaan-mahasiswa/{id}",
                    listOf(
                        navArgument("id") {
                            type = NavType.StringType
                        }
                    )) { backStackEntry ->
                    title.value = "Edit Pengelolaan Mahasiswa"
                    val id = backStackEntry.arguments?.getString("id")
                        ?: return@composable
                    FormPencatatanMahasiswaScreen(navController =
                    navController, id = id, modifier =
                    Modifier.padding(innerPadding))
                }

                //Matakuliah
                composable("pengelolaan-matakuliah") {
                    title.value = "Pengelolaan Matakuliah"
                    PengelolaanMatakuliahScreen(navController =
                    navController, snackbarHostState =
                    scaffoldState.snackbarHostState, modifier =
                    Modifier.padding(innerPadding))
                }

                composable("tambah-pengelolaan-matakuliah") {
                    title.value = "Tambah Pengelolaan Matakuliah"
                    FormPencatatanMatakuliahScreen(navController =
                    navController, modifier = Modifier.padding(innerPadding))
                }

                composable("edit-pengelolaan-matakuliah/{id}",
                    listOf(
                        navArgument("id") {
                            type = NavType.StringType
                        }
                    )) { backStackEntry ->
                    title.value = "Edit Pengelolaan Matakuliah"
                    val id = backStackEntry.arguments?.getString("id")
                        ?: return@composable
                    FormPencatatanMatakuliahScreen(navController =
                    navController, id = id, modifier =
                    Modifier.padding(innerPadding))
                }
            }
        }
    }
}
