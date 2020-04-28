package com.ebookfrenzy.assignment4fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ToggleButton
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.tempfragment.*

class tempfragment : Fragment(){
    override fun onAttach(context: Context) {
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
        val view = inflater.inflate(R.layout.tempfragment, container, false)

        val toggleButtonCF: ToggleButton? = view?.findViewById(R.id.toggleButtonCF)

        val toggleButtonCF?.setOnClickListener {v: View -> onSwitchClick(v)}

        return view
    }

}

