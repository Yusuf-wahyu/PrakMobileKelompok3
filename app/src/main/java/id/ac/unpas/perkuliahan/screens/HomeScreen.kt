package id.ac.unpas.perkuliahan.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import id.ac.unpas.perkuliahan.R


@Composable
fun HomeScreen(navController : NavHostController, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.kelompok3),
        contentDescription = "Gambar",
        modifier = Modifier.fillMaxWidth()

    )
    Column(
        modifier = Modifier.fillMaxWidth(),
       verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                navController.navigate("pengelolaan-dosen")
            },
            modifier = Modifier.padding(15.dp).size(350.dp, 50.dp)
        ) {
            Text(text = "Halaman Dosen")
        }

        Button(
            onClick = {
                navController.navigate("pengelolaan-mahasiswa")
            },
            modifier = Modifier.padding(15.dp).size(350.dp, 50.dp)
        ) {
            Text(text = "Halaman Mahasiswa")
        }

        Button(
            onClick = {
                navController.navigate("pengelolaan-matakuliah")
            },
            modifier = Modifier.padding(15.dp).size(350.dp, 50.dp)
        ) {
            Text(text = "Halaman Matakuliah")
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}