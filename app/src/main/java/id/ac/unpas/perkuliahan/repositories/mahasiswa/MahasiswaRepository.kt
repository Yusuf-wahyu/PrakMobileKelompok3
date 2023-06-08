package id.ac.unpas.perkuliahan.repositories.mahasiswa

import com.benasher44.uuid.uuid4
import com.skydoves.sandwich.*
import com.skydoves.whatif.whatIfNotNull
import id.ac.unpas.perkuliahan.model.Mahasiswa
import id.ac.unpas.perkuliahan.networks.mahasiswa.MahasiswaApi
import id.ac.unpas.perkuliahan.persistences.mahasiswa.MahasiswaDao
import javax.inject.Inject

class MahasiswaRepository @Inject constructor(
    private val api: MahasiswaApi,
    private val dao: MahasiswaDao
) : Repository {
    suspend fun loadItems(
        onSuccess: (List<Mahasiswa>) -> Unit,
        onError: (List<Mahasiswa>, String) -> Unit
    ) {
        val list: List<Mahasiswa> = dao.getList()
        api.all()
            .suspendOnSuccess {
                data.whatIfNotNull {
                    it.data?.let { list ->
                        dao.insertAll(list)
                        val items: List<Mahasiswa> =
                            dao.getList()
                        onSuccess(items)
                    }
                }
            }
            .suspendOnError {
                onError(list, message())
            }
            .suspendOnException {
                onError(list, message())
            }
    }
    suspend fun insert(
        npm: String,
        nama: String,
        tanggal_lahir: String,
        jenis_kelamin: String,
        onSuccess: (Mahasiswa) -> Unit,
        onError: (Mahasiswa?, String) -> Unit
    ) {
        val id = uuid4().toString()
        val item = Mahasiswa(id, npm, nama, tanggal_lahir, jenis_kelamin)
        dao.insertAll(item)
        api.insert(item)
            .suspendOnSuccess {
                onSuccess(item)
            }
            .suspendOnError {
                onError(item, message())
            }
            .suspendOnException {
                onError(item, message())
            }
    }

    suspend fun update(
        id: String,
        npm: String,
        nama: String,
        tanggal_lahir: String,
        jenis_kelamin: String,
        onSuccess: (Mahasiswa) -> Unit,
        onError: (Mahasiswa?, String) -> Unit
    ) {
        val item = Mahasiswa(id, npm, nama, tanggal_lahir, jenis_kelamin)
        dao.insertAll(item)
        api.update(id, item)
            .suspendOnSuccess {
                onSuccess(item)
            }
            .suspendOnError {
                onError(item, message())
            }
            .suspendOnException {
                onError(item, message())
            }
    }

    suspend fun delete(id: String, onSuccess: () -> Unit,
                       onError: (String) -> Unit) {
        dao.delete(id)
        api.delete(id)
            .suspendOnSuccess {
                data.whatIfNotNull {
                    onSuccess()
                }
            }
            .suspendOnError {
                onError(message())
            }
            .suspendOnException {
                onError(message())
            }
    }

    suspend fun find(id: String) : Mahasiswa? {
        return dao.find(id)
    }
}