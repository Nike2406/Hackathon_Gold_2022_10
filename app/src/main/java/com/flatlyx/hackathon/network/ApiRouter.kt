package com.flatlyx.hackathon.network

object ApiRouter {

    suspend fun login(username: String, password: String) =
        ApiBuilder.get().driverLogin(ApiBuilder.getBody(
            "username" to username, "password" to password))

    suspend fun driver(id: Int) = ApiBuilder.get().driverGet(id)
}