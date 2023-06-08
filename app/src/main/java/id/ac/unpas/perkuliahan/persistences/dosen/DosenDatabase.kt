package id.ac.unpas.perkuliahan.persistences.dosen

import androidx.room.Database
import androidx.room.RoomDatabase
import id.ac.unpas.perkuliahan.model.Dosen

@Database(entities = [Dosen::class], version = 2)
abstract class DosenDatabase : RoomDatabase() {
    abstract fun dosenDao(): DosenDao
}