package id.ac.unpas.perkuliahan.networks.matakuliah

import com.skydoves.sandwich.ApiResponse
import id.ac.unpas.perkuliahan.model.Matakuliah
import retrofit2.http.*

interface MatakuliahApi {
    @GET("matakuliah")
    suspend fun all(): ApiResponse<MatakuliahGetResponse>
    @GET("matakuliah/{id}")
    suspend fun find(@Path("id") id: String):
            ApiResponse<MatakuliahSingeGetResponse>
    @POST("matakuliah")
    @Headers("Content-Type: application/json")
    suspend fun insert(@Body item: Matakuliah):
            ApiResponse<MatakuliahGetResponse>
    @PUT("matakuliah/{id}")
    @Headers("Content-Type: application/json")
    suspend fun update(@Path("id") pathId: String,
                       @Body item: Matakuliah
    ):
            ApiResponse<MatakuliahSingeGetResponse>
    @DELETE("matakuliah/{id}")
    suspend fun delete(@Path("id") id: String):
            ApiResponse<MatakuliahSingeGetResponse>
}