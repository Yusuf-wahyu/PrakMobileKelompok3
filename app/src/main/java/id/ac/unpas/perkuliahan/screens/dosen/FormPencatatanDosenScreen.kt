package id.ac.unpas.perkuliahan.screens.dosen

import androidx.compose.foundation.clickable
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
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import id.ac.unpas.perkuliahan.model.Dosen
import id.ac.unpas.perkuliahan.ui.theme.Purple700
import id.ac.unpas.perkuliahan.ui.theme.Teal200
import kotlinx.coroutines.launch
import java.time.format.DateTimeFormatter

@Composable
fun FormPencatatanDosenScreen (navController: NavHostController, id: String? = null, modifier: Modifier = Modifier) {
    val viewModel = hiltViewModel<PengelolaanDosenViewModel>()
    val nidn = remember { mutableStateOf(TextFieldValue("")) }
    val nama = remember { mutableStateOf(TextFieldValue("")) }
    val gelar_depan = remember { mutableStateOf(TextFieldValue("")) }
    val gelar_belakang = remember { mutableStateOf(TextFieldValue("")) }
    val pendidikan = remember { mutableStateOf(TextFieldValue("")) }
    val scope = rememberCoroutineScope()
    val isLoading = remember { mutableStateOf(false) }
    val buttonLabel = if (isLoading.value) "Mohon tunggu..." else "Simpan"

    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            label = { Text(text = "NIDN") },
            value = nidn.value,
            onValueChange = {
                nidn.value = it
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
            label = { Text(text = "Gelar Depan") },
            value = gelar_depan.value,
            onValueChange = {
                gelar_depan.value = it
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
            label = { Text(text = "Gelar Belakang") },
            value = gelar_belakang.value,
            onValueChange = {
                gelar_belakang.value = it
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
            label = { Text(text = "Pendidikan") },
            value = pendidikan.value,
            onValueChange = {
                pendidikan.value = it
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
                            viewModel.insert(nidn.value.text, nama.value.text, gelar_depan.value.text
                            , gelar_belakang.value.text, pendidikan.value.text)
                        }
                    } else {
                        scope.launch {
                            viewModel.update(
                                id,
                                nidn.value.text,
                                nama.value.text,
                                gelar_depan.value.text,
                                gelar_belakang.value.text,
                                pendidikan.value.text,
                            )
                        }
                    }
                    navController.navigate("pengelolaan-dosen")
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
                nidn.value = TextFieldValue("")
                nama.value = TextFieldValue("")
                gelar_depan.value = TextFieldValue("")
                gelar_belakang.value = TextFieldValue("")
                pendidikan.value = TextFieldValue("")
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
            viewModel.loadItem(id) {  Dosen ->
                Dosen?.let {
                    nidn.value = TextFieldValue(Dosen.nidn)
                    nama.value = TextFieldValue(Dosen.nama)
                    gelar_depan.value = TextFieldValue( Dosen.gelar_depan)
                    gelar_belakang.value = TextFieldValue(Dosen.gelar_belakang)
                    pendidikan.value = TextFieldValue(Dosen.pendidikan)
                }
            }
        }
    }
}