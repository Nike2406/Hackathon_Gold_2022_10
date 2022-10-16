package com.flatlyx.hackathon.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.flatlyx.hackathon.databinding.ActivityMainBinding
import com.flatlyx.hackathon.databinding.IncludeHeaderInfoMapBinding

class HeaderInfoMapFragment : Fragment() {

        lateinit var binding: IncludeHeaderInfoMapBinding
        lateinit var bindingRoot: ActivityMainBinding

        override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
            binding = IncludeHeaderInfoMapBinding.inflate(inflater)
            bindingRoot = ActivityMainBinding.inflate(inflater)
//            mBottomSheetLayout = binding.bottomSheetLayout
//            sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
//            return binding.root
//            return inflater.inflate(R.layout.bottom_sheet_dialog_layout, container, false)
            return binding.root
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingRoot.placeHolderBottom.visibility = View.VISIBLE
    }

    override fun onPause() {
        super.onPause()
        bindingRoot.placeHolderBottom.visibility = View.GONE
    }

    companion object {

        @JvmStatic
        fun newInstance() = HeaderInfoMapFragment()
    }
}