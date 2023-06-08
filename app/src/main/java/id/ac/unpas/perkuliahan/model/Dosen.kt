package id.ac.unpas.perkuliahan.model

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity
@Immutable
data class Dosen(
    @PrimaryKey val id: String,
    val nidn: String,
    val nama: String,
    @SerializedName("gelar_depan")
    val gelar_depan: String,
    @SerializedName("gelar_belakang")
    val gelar_belakang: String,
    val pendidikan: String,

)


