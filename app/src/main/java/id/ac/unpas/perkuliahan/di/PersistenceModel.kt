package id.ac.unpas.perkuliahan.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.ac.unpas.perkuliahan.persistences.dosen.DosenDao
import id.ac.unpas.perkuliahan.persistences.dosen.DosenDatabase
import id.ac.unpas.perkuliahan.persistences.mahasiswa.MahasiswaDao
import id.ac.unpas.perkuliahan.persistences.mahasiswa.MahasiswaDatabase
import id.ac.unpas.perkuliahan.persistences.matakuliah.MatakuliahDao
import id.ac.unpas.perkuliahan.persistences.matakuliah.MatakuliahDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModel {
    @Provides
    @Singleton
    fun provideDosenDatabase(application: Application): DosenDatabase {
        return Room
            .databaseBuilder(
                application,
                DosenDatabase::class.java,
                "pengelolaan-dosen"
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideDosenDao(appDatabase: DosenDatabase): DosenDao {
        return appDatabase.dosenDao()
    }

    @Provides
    @Singleton
    fun provideMahasiswaDatabase(application: Application): MahasiswaDatabase {
        return Room
            .databaseBuilder(
                application,
                MahasiswaDatabase::class.java,
                "pengelolaan-mahasiswa"
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideMahasiswaDao(appDatabase: MahasiswaDatabase): MahasiswaDao {
        return appDatabase.mahasiswaDao()
    }

    @Provides
    @Singleton
    fun provideMatakuliahDatabase(application: Application): MatakuliahDatabase {
        return Room
            .databaseBuilder(
                application,
                MatakuliahDatabase::class.java,
                "pengelolaan-matakuliah"
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideMataKuliahDao(appDatabase: MatakuliahDatabase): MatakuliahDao {
        return appDatabase.mataKuliahDao()
    }
}