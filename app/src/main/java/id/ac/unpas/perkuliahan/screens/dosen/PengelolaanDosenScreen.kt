package id.ac.unpas.perkuliahan.screens.dosen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import id.ac.unpas.perkuliahan.model.Dosen
import kotlinx.coroutines.launch

@Composable
fun PengelolaanDosenScreen(navController : NavHostController,
                            snackbarHostState: SnackbarHostState, modifier: Modifier =
                                Modifier) {
    val viewModel = hiltViewModel<PengelolaanDosenViewModel>()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val items: List<Dosen> by
    viewModel.list.observeAsState(initial = listOf())
    Column(modifier = modifier.fillMaxWidth()) {
        Button(onClick = {
            navController.navigate("tambah-pengelolaan-dosen")
        }) {
            Text(text = "Tambah")
        }
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(items = items, itemContent = { item ->
                DosenItem(item = item, navController =
                navController) {
                    scope.launch {
                        viewModel.delete(it)
                    }
                }
            })
        }
    }

    LaunchedEffect(scope) {
        viewModel.loadItems()
    }
    viewModel.success.observe(LocalLifecycleOwner.current) {
        if (it) {
            scope.launch {
                viewModel.loadItems()
            }
        }
    }
    viewModel.toast.observe(LocalLifecycleOwner.current) {
        scope.launch {
            snackbarHostState.showSnackbar(it, actionLabel =
            "Tutup", duration = SnackbarDuration.Long)
        }
    }
}