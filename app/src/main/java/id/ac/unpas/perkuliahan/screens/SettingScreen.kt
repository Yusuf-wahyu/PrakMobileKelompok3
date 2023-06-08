package id.ac.unpas.perkuliahan.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import id.ac.unpas.perkuliahan.R


@Composable
fun SettingScreen(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.credit), // Ganti "your_image" dengan nama file gambar Anda
        contentDescription = "Gambar",
        modifier = Modifier.fillMaxWidth()
        //.size(400.dp, 4000.dp) // Mengatur ukuran gambar
        //.padding(10.dp)
    )

}