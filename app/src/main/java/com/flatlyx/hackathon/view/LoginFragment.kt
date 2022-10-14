package com.flatlyx.hackathon.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.flatlyx.hackathon.R
import com.flatlyx.hackathon.databinding.FragmentLoginBinding

class LoginFragment: Fragment() {

    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            activity?.let {
                it.supportFragmentManager.beginTransaction()
                    .replace(R.id.place_holder, GagFragment.newInstance())
                    .addToBackStack(null)
                    .commit()
            }
        }

        binding.btnLoginRegistration.setOnClickListener {
            activity?.let {
                it.supportFragmentManager.beginTransaction()
                    .replace(R.id.place_holder, RegistrationFragment.newInstance())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}