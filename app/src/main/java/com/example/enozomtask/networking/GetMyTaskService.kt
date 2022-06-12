package com.example.enozomtask.networking

import com.google.gson.JsonObject
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface GetMyTaskService {

    @Headers(
        "x-api-key: BC_8d48b51fcef84ad391daedac8a6f676d_R4Sh8ZBAdzKCW4PkmF06xI7cvBVFqgCNdAZxX74r0t4=",
        "Content-Type: application/json"
    )
    @GET("GetMyTask")
    suspend fun getMyTaskData(): Response<JsonObject>


    @Headers(
        "x-api-key: BC_8d48b51fcef84ad391daedac8a6f676d_R4Sh8ZBAdzKCW4PkmF06xI7cvBVFqgCNdAZxX74r0t4=",
        "Content-Type: application/json"
    )
    @POST("SubmitResult")
    suspend fun postResult(
        @Body requestBody: RequestBody
    ): Response<JsonObject>


}