package com.flatlyx.hackathon.view.recyclerViewOrders

import androidx.recyclerview.widget.DiffUtil
import com.flatlyx.hackathon.model.Order

class OrderDiffCallback : DiffUtil.ItemCallback<Order>() {
    override fun areItemsTheSame(oldItem: Order, newItem: Order): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Order, newItem: Order): Boolean {
        return oldItem == newItem
    }
}