package id.ac.unpas.perkuliahan.screens.matakuliah

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import id.ac.unpas.perkuliahan.model.Matakuliah
import id.ac.unpas.perkuliahan.ui.theme.Purple700
import id.ac.unpas.perkuliahan.ui.theme.Teal200
import kotlinx.coroutines.launch

@Composable
fun FormPencatatanMatakuliahScreen (navController: NavHostController, id: String? = null, modifier: Modifier = Modifier) {
    val viewModel = hiltViewModel<PengelolaanMatakuliahViewModel>()
    val kode = remember { mutableStateOf(TextFieldValue("")) }
    val nama = remember { mutableStateOf(TextFieldValue("")) }
    val sks = remember { mutableStateOf(TextFieldValue("")) }
    val praktikum = remember { mutableStateOf(TextFieldValue("")) }
    val deskripsi = remember { mutableStateOf(TextFieldValue("")) }
    val scope = rememberCoroutineScope()
    val isLoading = remember { mutableStateOf(false) }
    val buttonLabel = if (isLoading.value) "Mohon tunggu..." else "Simpan"

    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            label = { Text(text = "Kode Matakuliah") },
            value = kode.value,
            onValueChange = {
                kode.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                capitalization =
                KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text
            ),
            placeholder = { Text(text = "XXXXX") }
        )
        OutlinedTextField(
            label = { Text(text = "Nama") },
            value = nama.value,
            onValueChange = {
                nama.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                capitalization =
                KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text
            ),
            placeholder = { Text(text = "XXXXX") }
        )
        OutlinedTextField(
            label = { Text(text = "SKS") },
            value = sks.value,
            onValueChange = {
                sks.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType =
                KeyboardType.Decimal
            ),
            placeholder = { Text(text = "XXXXX") }
        )
        OutlinedTextField(
            label = { Text(text = "Praktikum") },
            value = praktikum.value,
            onValueChange = {
                praktikum.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType =
                KeyboardType.Decimal
            ),
            placeholder = { Text(text = "XXXXX") }
        )
        OutlinedTextField(
            label = { Text(text = "Deskripsi") },
            value = deskripsi.value,
            onValueChange = {
                deskripsi.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType =
                KeyboardType.Decimal
            ),
            placeholder = { Text(text = "XXXXX") }
        )

        val loginButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Purple700,
            contentColor = Teal200
        )
        val resetButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Teal200,
            contentColor = Purple700
        )
        Row(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        ) {
            Button(modifier = Modifier.weight(5f),
                onClick = {
                    if (id == null) {
                        scope.launch {
                            viewModel.insert(kode.value.text, nama.value.text, sks.value.text.toByte()
                            , praktikum.value.text.toInt() ,deskripsi.value.text)
                        }
                    } else {
                        scope.launch {
                            viewModel.update(
                                id,
                                nama.value.text,
                                nama.value.text,
                                sks.value.text.toByte(),
                                praktikum.value.text.toInt(),
                                deskripsi.value.text,
                            )
                        }
                    }
                    navController.navigate("pengelolaan-matakuliah")
                }, colors = loginButtonColors
            ) {
                Text(
                    text = buttonLabel,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
            Button(modifier = Modifier.weight(5f), onClick = {
                kode.value = TextFieldValue("")
                nama.value = TextFieldValue("")
                sks.value = TextFieldValue("")
                praktikum.value = TextFieldValue("")
                deskripsi.value = TextFieldValue("")
            }, colors = resetButtonColors) {
                Text(
                    text = "Reset",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
    viewModel.isLoading.observe(LocalLifecycleOwner.current) {
        isLoading.value = it
    }

    if (id != null) {
        LaunchedEffect(scope) {
            viewModel.loadItem(id) { Matakuliah ->
                Matakuliah?.let {
                    kode.value = TextFieldValue(Matakuliah.kode)
                    nama.value = TextFieldValue(Matakuliah.nama)
                    sks.value = TextFieldValue( Matakuliah.sks.toString())
                    praktikum.value = TextFieldValue(Matakuliah.praktikum.toString())
                    deskripsi.value = TextFieldValue(Matakuliah.deskripsi)
                }
            }
        }
    }
}