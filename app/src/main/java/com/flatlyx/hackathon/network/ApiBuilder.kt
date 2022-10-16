package com.flatlyx.hackathon.network

import okhttp3.OkHttpClient
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiBuilder {

    private const val baseUrl = "https://ac64af35-0340-4844-ae8c-9bc56b81a8dc.mock.pstmn.io"

    private var instance: ApiService? = null

    fun get(): ApiService {
        if (instance == null) {
            instance = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
        return instance!!
    }

    fun getBody(vararg params: Pair<String, String>): RequestBody {
        return  RequestBody.create(
            okhttp3.MediaType.parse("application/json; charset=utf-8"),
            JSONObject(mapOf(*params)).toString())
    }
}