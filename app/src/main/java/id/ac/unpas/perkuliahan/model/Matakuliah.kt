package id.ac.unpas.perkuliahan.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.annotation.concurrent.Immutable

@Entity
@Immutable
data class Matakuliah(
    @PrimaryKey
    val id: String,
    val kode: String,
    val nama: String,
    val sks: Byte,
    val praktikum: Int,
    val deskripsi: String
)
