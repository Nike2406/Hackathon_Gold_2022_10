package com.flatlyx.hackathon.model

data class Order(
    val img: Int,
    val area: String,
    val address: String,
    val timeLeft: String,
    var id: Int = UNDEFINED_ID,
) {
    companion object {
        const val UNDEFINED_ID = -1
    }
}