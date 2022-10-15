package com.flatlyx.hackathon.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.flatlyx.hackathon.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MapPopupFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_map_popup, container, false)


    companion object {
        const val TAG = "ModalBottomSheet"
    }
}