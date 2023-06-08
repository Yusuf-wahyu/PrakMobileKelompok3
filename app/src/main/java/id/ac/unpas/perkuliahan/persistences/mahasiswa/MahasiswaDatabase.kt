package id.ac.unpas.perkuliahan.persistences.mahasiswa

import androidx.room.Database
import androidx.room.RoomDatabase
import id.ac.unpas.perkuliahan.model.Mahasiswa

@Database(entities = [Mahasiswa::class], version = 1)
abstract class MahasiswaDatabase : RoomDatabase() {
    abstract fun mahasiswaDao(): MahasiswaDao
}