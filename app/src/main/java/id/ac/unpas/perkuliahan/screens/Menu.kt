package id.ac.unpas.perkuliahan.screens

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import id.ac.unpas.perkuliahan.R

enum class Menu (
    @StringRes val title: Int,
    val icon: ImageVector,
    val route: String
) {
    HOME(R.string.home, Icons.Default.Home, "home"),
    PENGELOLAAN_DOSEN(R.string.pengelolaan_dosen, Icons.Default.Person, "pengelolaan-dosen"),
    PENGELOLAAN_MAHASISWA(R.string.pengelolaan_mahasiswa, Icons.Default.Person, "pengelolaan-mahasiswa"),
    PENGELOLAAN_MATAKULIAH(R.string.pengelolaan_matakuliah, Icons.Default.Person, "pengelolaan-matakuliah"),
    SETTING(R.string.setting, Icons.Default.Settings, "setting");

    companion object {
        fun getTabFromResource(@StringRes resource: Int): Menu
        {
            return when(resource) {
                R.string.home -> HOME
                R.string.pengelolaan_dosen -> PENGELOLAAN_DOSEN
                R.string.pengelolaan_matakuliah -> PENGELOLAAN_MATAKULIAH
                else -> SETTING
            }
        }
    }
}