package id.ac.unpas.perkuliahan.model

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

//enum class JenisKelamin {
//    Laki_Laki,
//    Perempuan
//}

@Entity
@Immutable
data class Mahasiswa(
    @PrimaryKey val id: String,
    val npm: String,
    val nama: String,
    @SerializedName("tanggal_lahir")
    val tanggal_lahir: String,
    @SerializedName("jenis_kelamin")
    val jenis_kelamin: String
)
