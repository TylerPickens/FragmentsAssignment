package com.ebookfrenzy.assignment4fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ToggleButton
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.length_fragment.*
import kotlinx.android.synthetic.main.mass_fragment.*
import kotlinx.android.synthetic.main.temp_fragment.*
import kotlinx.android.synthetic.main.temp_fragment.view.*
import java.text.DecimalFormat

class MassFragment : Fragment(){
    var isKG = true
    val TAG = "HEYO"
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
        val view = inflater.inflate(R.layout.mass_fragment, container, false)
        val buttonKGP: Button? = view?.findViewById(R.id.buttonKGP)
        val toggleButtonKGP: ToggleButton? = view?.findViewById(R.id.toggleButtonKGP)

        buttonKGP?.setOnClickListener {v: View -> onButtonClick(v)}
        toggleButtonKGP?.setOnClickListener {v: View -> onSwitchClick(v)}

        return view
    }

    private fun onButtonClick(v: View) {
        val input = massKGP.text.toString()
        var isNumeric: Boolean = true
        var displayMass: String = ""
        var conversionType: String = ""

        isNumeric = input.matches("-?\\d+(\\.\\d+)?".toRegex())

        if(isNumeric){
            val inputNumber = input.toInt();
            val df = DecimalFormat("#.#")

            if(isKG){
                val result = KGtoP(inputNumber)
                conversionType = "KGtoP"
                displayMass = df.format(result)
                displayMass += " P"
                textViewKGP.text=displayMass
            }else{
                val result = PtoKG(inputNumber)
                conversionType = "PtoKG"
                displayMass = df.format(result)
                displayMass += " KG"
                textViewKGP.text=displayMass
            }
        }else{
            Log.i(TAG,"That was not a number")
        }

    }
    //changes toggleButton between measurements
    private fun onSwitchClick(view: View) {
        if( isKG ){
            toggleButtonKGP?.textOn = "To Pounds"
            isKG = false
        }else{
            toggleButtonKGP?.textOff = "To KG"
            isKG = true
        }

    }
    //Conversion equations

    private fun KGtoP(mass: Int): Float {
        return (mass) / 2.2f
    }

    private fun PtoKG(mass: Int): Float{
        return (mass) * 2.2f
    }



}