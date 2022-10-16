package com.flatlyx.hackathon.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.flatlyx.hackathon.R
import com.flatlyx.hackathon.databinding.FragmentRegistrationBinding

class RegistrationFragment: Fragment() {

    lateinit var binding: FragmentRegistrationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnRegistration.setOnClickListener {
            activity?.let {
                it.supportFragmentManager.beginTransaction()
                    .setCustomAnimations(
                        androidx.appcompat.R.anim.abc_fade_in,
                        androidx.appcompat.R.anim.abc_fade_out
                    )
                    .replace(R.id.place_holder, OrdersFragment.newInstance())
                    .addToBackStack(null)
                    .commit()
            }
        }

        binding.btnRegistrationLogin.setOnClickListener {
            activity?.let {
                it.supportFragmentManager.beginTransaction()
                    .setCustomAnimations(
                        androidx.appcompat.R.anim.abc_fade_in,
                        androidx.appcompat.R.anim.abc_fade_out
                    )
                    .replace(R.id.place_holder, LoginFragment.newInstance())
//                    .addToBackStack(null)
                    .commit()
            }
        }
    }
    companion object {

        @JvmStatic
        fun newInstance() = RegistrationFragment()
    }
}