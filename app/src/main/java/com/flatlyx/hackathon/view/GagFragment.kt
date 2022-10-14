package com.flatlyx.hackathon.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.flatlyx.hackathon.R
import com.flatlyx.hackathon.databinding.FragmentGagBinding

class GagFragment: Fragment() {

    private lateinit var binding: FragmentGagBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGagBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnExit.setOnClickListener {
            activity?.let {
                it.supportFragmentManager.beginTransaction()
                    .replace(R.id.place_holder, LoginFragment.newInstance())
//                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = GagFragment()
    }
}