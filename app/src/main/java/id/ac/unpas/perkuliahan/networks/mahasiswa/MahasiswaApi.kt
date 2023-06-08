package id.ac.unpas.perkuliahan.networks.mahasiswa

import com.skydoves.sandwich.ApiResponse
import id.ac.unpas.perkuliahan.model.Mahasiswa
import retrofit2.http.*

interface MahasiswaApi {
    @GET("mahasiswa")
    suspend fun all(): ApiResponse<MahasiswaGetResponse>
    @GET("mahasiswa/{id}")
    suspend fun find(@Path("id") id: String):
            ApiResponse<MahasiswaSingeGetResponse>
    @POST("mahasiswa")
    @Headers("Content-Type: application/json")
    suspend fun insert(@Body item: Mahasiswa):
            ApiResponse<MahasiswaGetResponse>
    @PUT("mahasiswa/{id}")
    @Headers("Content-Type: application/json")
    suspend fun update(@Path("id") pathId: String,
                       @Body item: Mahasiswa
    ):
            ApiResponse<MahasiswaSingeGetResponse>
    @DELETE("mahasiswa/{id}")
    suspend fun delete(@Path("id") id: String):
            ApiResponse<MahasiswaSingeGetResponse>
}