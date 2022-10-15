package com.flatlyx.hackathon.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.flatlyx.hackathon.R
import com.flatlyx.hackathon.databinding.FragmentLoadingBinding

class LoadingFragment : Fragment() {

    private lateinit var binding: FragmentLoadingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoadingBinding.inflate(inflater, container, false)
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
                    .replace(R.id.place_holder, LoginFragment.newInstance())
                    .commit()
            }, 500
        )
    }

    companion object {

        @JvmStatic
        fun newInstance() = LoadingFragment()
    }
}