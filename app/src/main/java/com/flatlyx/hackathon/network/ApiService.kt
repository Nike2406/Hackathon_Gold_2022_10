package com.flatlyx.hackathon.network

import com.flatlyx.hackathon.model.*
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("/driver/login")
    suspend fun driverLogin(@Body params: RequestBody) : Response<Driver>

    @GET("/driver/get")
    suspend fun driverGet(@Query("id") driverId: Int) : Response<Driver>
}