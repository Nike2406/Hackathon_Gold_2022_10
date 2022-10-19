package com.flatlyx.hackathon.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.flatlyx.hackathon.R
import com.flatlyx.hackathon.databinding.FragmentOrdersBinding
import com.flatlyx.hackathon.tempFillOrders.OrdersFactory
import com.flatlyx.hackathon.view.recyclerViewOrders.OrdersAdapter

class OrdersFragment : Fragment() {
    private lateinit var binding: FragmentOrdersBinding
    private lateinit var ordersAdapter: OrdersAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOrdersBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupClickListener()

        // Temp implementation of input data
        val orders = OrdersFactory().createOrders()
        ordersAdapter.submitList(orders)
    }

    private fun setupRecyclerView() {
        val rvOrders = binding.rvOrders
        ordersAdapter = OrdersAdapter()
        rvOrders.adapter = ordersAdapter
    }

    private fun setupClickListener() {
        ordersAdapter.onOrderClickListener = {
            requireActivity().supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                    androidx.appcompat.R.anim.abc_fade_in,
                    androidx.appcompat.R.anim.abc_fade_out
                )
                .replace(R.id.place_holder, MapFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = OrdersFragment()
    }
}