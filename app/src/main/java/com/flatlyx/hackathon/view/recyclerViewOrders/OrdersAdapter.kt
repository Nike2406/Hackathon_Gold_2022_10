package com.flatlyx.hackathon.view.recyclerViewOrders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.flatlyx.hackathon.R
import com.flatlyx.hackathon.model.Order

class OrdersAdapter : ListAdapter<Order, OrderViewHolder>(OrderDiffCallback()) {

    var onOrderClickListener:((Order) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val orderLayout = R.layout.include_order
        val view = LayoutInflater.from(parent.context)
            .inflate(orderLayout, parent, false)
        return OrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = getItem(position)
        holder.button.setOnClickListener {
            onOrderClickListener?.invoke(order)
            true
        }
        fillOrder(holder, order)
    }

    private fun fillOrder(holder: OrderViewHolder, order: Order?) {
        if (order != null) {
            holder.img.setImageResource(order.img)
            holder.area.text = order.area
            holder.address.text = order.address
            holder.timeLeft.text = order.timeLeft
            holder.button.text = AGREE
        }
    }

    companion object {
        const val AGREE = "ПРИНЯТЬ"
    }
}