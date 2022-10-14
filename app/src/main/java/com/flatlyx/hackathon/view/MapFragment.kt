package com.flatlyx.hackathon.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.flatlyx.hackathon.databinding.FragmentMapBinding
import com.yandex.mapkit.MapKitFactory

class MapFragment: Fragment() {

    private lateinit var binding: FragmentMapBinding
//    private MapView mapView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        MapKitFactory.initialize(container?.context);

        binding = FragmentMapBinding.inflate(inflater)
//        MapKitFactory.setApiKey("de65b04e-9dd7-4a8e-a97f-22d71032b780")
        return binding.root
    }


    companion object {
        @JvmStatic
        fun newInstance() = MapFragment()
    }
}