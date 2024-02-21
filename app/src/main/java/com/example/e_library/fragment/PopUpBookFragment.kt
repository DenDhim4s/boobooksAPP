package com.example.e_library.fragment

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.e_library.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PopUpBookFragment : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_pop_up_book,container,false)
    }


}


