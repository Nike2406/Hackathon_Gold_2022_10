package com.flatlyx.hackathon.view.recyclerViewOrders

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.flatlyx.hackathon.R

class OrderViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val img: ImageView = view.findViewById(R.id.ivOrder)
    val area: TextView = view.findViewById(R.id.tvTitleOrder)
    val address: TextView = view.findViewById(R.id.tvAddressOrder)
    val timeLeft: TextView = view.findViewById(R.id.tvLocationTime)
    val button: Button = view.findViewById(R.id.btnAgree)
}