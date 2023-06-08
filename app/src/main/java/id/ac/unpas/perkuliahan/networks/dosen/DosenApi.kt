package id.ac.unpas.perkuliahan.networks.dosen

import com.skydoves.sandwich.ApiResponse
import id.ac.unpas.perkuliahan.model.Dosen
import retrofit2.http.*

interface DosenApi {
    @GET("dosen")
    suspend fun all(): ApiResponse<DosenGetResponse>
    @GET("dosen/{id}")
    suspend fun find(@Path("id") id: String):
            ApiResponse<DosenSingeGetResponse>
    @POST("dosen")
    @Headers("Content-Type: application/json")
    suspend fun insert(@Body item: Dosen):
            ApiResponse<DosenGetResponse>
    @PUT("dosen/{id}")
    @Headers("Content-Type: application/json")
    suspend fun update(@Path("id") pathId: String,
                       @Body item: Dosen
    ):
            ApiResponse<DosenSingeGetResponse>
    @DELETE("dosen/{id}")
    suspend fun delete(@Path("id") id: String):
            ApiResponse<DosenSingeGetResponse>
}