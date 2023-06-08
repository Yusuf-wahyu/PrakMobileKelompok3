package id.ac.unpas.perkuliahan.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import id.ac.unpas.perkuliahan.networks.dosen.DosenApi
import id.ac.unpas.perkuliahan.networks.mahasiswa.MahasiswaApi
import id.ac.unpas.perkuliahan.networks.matakuliah.MatakuliahApi
import id.ac.unpas.perkuliahan.persistences.dosen.DosenDao
import id.ac.unpas.perkuliahan.persistences.mahasiswa.MahasiswaDao
import id.ac.unpas.perkuliahan.persistences.matakuliah.MatakuliahDao
import id.ac.unpas.perkuliahan.repositories.dosen.DosenRepository
import id.ac.unpas.perkuliahan.repositories.mahasiswa.MahasiswaRepository
import id.ac.unpas.perkuliahan.repositories.matakuliah.MatakuliahRepository

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    @ViewModelScoped
    fun provideDosenRepository(
        api: DosenApi,
        dao: DosenDao
    ): DosenRepository {
        return DosenRepository(api, dao)
    }

    @Provides
    @ViewModelScoped
    fun provideMahasiswaRepository(
        api: MahasiswaApi,
        dao: MahasiswaDao
    ): MahasiswaRepository {
        return MahasiswaRepository(api, dao)
    }

    @Provides
    @ViewModelScoped
    fun provideMatakulaihRepository(
        api: MatakuliahApi,
        dao: MatakuliahDao
    ): MatakuliahRepository {
        return MatakuliahRepository(api, dao)
    }
}