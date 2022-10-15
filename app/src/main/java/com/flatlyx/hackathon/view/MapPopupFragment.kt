package com.flatlyx.hackathon.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.flatlyx.hackathon.databinding.BottomSheetDialogLayoutBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MapPopupFragment : BottomSheetDialogFragment() {

        lateinit var binding: BottomSheetDialogLayoutBinding
        lateinit var mBottomSheetLayout: LinearLayout
        lateinit var sheetBehavior: BottomSheetBehavior<LinearLayout>
        lateinit var headerArrowImage: ImageView

        override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            binding = BottomSheetDialogLayoutBinding.inflate(inflater)

            mBottomSheetLayout = binding.bottomSheetLayout
            sheetBehavior = BottomSheetBehavior.from(mBottomSheetLayout)
            sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            return binding.root
//            return inflater.inflate(R.layout.bottom_sheet_dialog_layout, container, false)

        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        headerArrowImage = binding.bottomSheetArrow

        headerArrowImage.setOnClickListener {
            if(sheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED){
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            } else {
                sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        }

        sheetBehavior.addBottomSheetCallback(object : BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {}
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                headerArrowImage.rotation = slideOffset * 180
            }
        })
    }


    companion object {
        const val TAG = "ModalBottomSheet"
    }
}