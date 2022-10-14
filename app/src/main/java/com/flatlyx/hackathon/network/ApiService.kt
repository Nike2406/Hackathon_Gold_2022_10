package com.flatlyx.hackathon.network

import com.flatlyx.hackathon.model.QuoteList
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    // Для теста
    @GET("/quotes")
    suspend fun getQuotes() : Response<QuoteList>
}