package com.flatlyx.hackathon.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.flatlyx.hackathon.R
import com.flatlyx.hackathon.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.postDelayed({
            requireActivity().supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                    androidx.appcompat.R.anim.abc_fade_in,
                    androidx.appcompat.R.anim.abc_fade_out
                )
                .replace(R.id.place_holder, LoadingFragment.newInstance())
                .commit()
        }, 3000)
    }

    companion object {

        @JvmStatic
        fun newInstance() = WelcomeFragment()
    }
}