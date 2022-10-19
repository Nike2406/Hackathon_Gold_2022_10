package com.flatlyx.hackathon.tempFillOrders

import com.flatlyx.hackathon.R
import com.flatlyx.hackathon.model.Order
import kotlin.random.Random

class OrdersFactory {

    fun createOrders(): List<Order> {
        val orders = mutableListOf<Order>()
        for (i in 1..100) {
            orders.add(
                Order(
                    R.drawable.random_img,
                    "Поющая пропасть",
                    "Поднебесная, $i",
                    (Random.nextFloat() * 10).toString().take(3),
                    1
                )
            )
        }
        return orders
    }
}