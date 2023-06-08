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
        painter = painterResource(R.drawable.kelompok3), // Ganti "your_image" dengan nama file gambar Anda
        contentDescription = "Gambar",
        modifier = Modifier.fillMaxWidth()
            //.size(400.dp, 4000.dp) // Mengatur ukuran gambar
            //.padding(10.dp)
    )
    Column(
        modifier = Modifier.fillMaxWidth(),
       verticalArrangement = Arrangement.Center, // Mengatur penempatan vertikal ke tengah
        horizontalAlignment = Alignment.CenterHorizontally // Mengatur penempatan horizontal ke tengah
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                navController.navigate("pengelolaan-dosen")
            },
            modifier = Modifier.padding(15.dp).size(350.dp, 50.dp) // Menambahkan padding agar tombol terlihat lebih baik
        ) {
            Text(text = "Halaman Dosen")
        }

        Button(
            onClick = {
                navController.navigate("pengelolaan-mahasiswa")
            },
            modifier = Modifier.padding(15.dp).size(350.dp, 50.dp) // Menambahkan padding agar tombol terlihat lebih baik
        ) {
            Text(text = "Halaman Mahasiswa")
        }

        Button(
            onClick = {
                navController.navigate("pengelolaan-matakuliah")
            },
            modifier = Modifier.padding(15.dp).size(350.dp, 50.dp) // Menambahkan padding agar tombol terlihat lebih baik
        ) {
            Text(text = "Halaman Matakuliah")
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}