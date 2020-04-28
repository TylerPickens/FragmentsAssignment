package com.ebookfrenzy.assignment4fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.fragment.app.Fragment
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.tempfragment.*

class tempfragment : Fragment(){
    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater: LayoutInflater?, container, savedInstanceState)
    }

}

