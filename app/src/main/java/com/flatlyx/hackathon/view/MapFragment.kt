package com.flatlyx.hackathon.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.flatlyx.hackathon.databinding.FragmentMapBinding
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition

class MapFragment : Fragment() {

    private lateinit var binding: FragmentMapBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        MapKitFactory.initialize(container?.context);

        binding = FragmentMapBinding.inflate(inflater)
        binding.mapview.map.move(
            CameraPosition(
                Point(55.751574, 37.573856),
                11.0f, 0.0f, 0.0f
            ),
            Animation(Animation.Type.SMOOTH, 0F),
            null
        )

//        requireActivity().supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.place_holder_bottom, HeaderInfoMapFragment.newInstance())
//            .commit()

//        val mapPopupFragment = MapPopupFragment()
//        mapPopupFragment.show(
//            requireActivity().supportFragmentManager,
//            MapPopupFragment.TAG
//        )

        return binding.root
    }

    override fun onStop() {
        binding.mapview.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        binding.mapview.onStart()
    }

    companion object {
        @JvmStatic
        fun newInstance() = MapFragment()
    }
}