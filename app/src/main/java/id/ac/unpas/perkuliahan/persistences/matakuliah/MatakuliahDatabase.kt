package id.ac.unpas.perkuliahan.persistences.matakuliah

import androidx.room.Database
import androidx.room.RoomDatabase
import id.ac.unpas.perkuliahan.model.Matakuliah

@Database(entities = [Matakuliah::class], version = 1)
abstract class MatakuliahDatabase : RoomDatabase() {
    abstract fun mataKuliahDao(): MatakuliahDao
}