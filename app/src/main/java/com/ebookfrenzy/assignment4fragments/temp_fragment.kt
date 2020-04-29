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
import kotlinx.android.synthetic.main.temp_fragment.*
import kotlinx.android.synthetic.main.temp_fragment.view.*
import java.text.DecimalFormat

class temp_fragment : Fragment(){
    var isCelsius = true
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
        val view = inflater.inflate(R.layout.temp_fragment, container, false)
        val buttonCF: Button? = view?.findViewById(R.id.buttonCF)
        val toggleButtonCF: ToggleButton? = view?.findViewById(R.id.toggleButtonCF)

        buttonCF?.setOnClickListener {v: View -> onButtonClick(v)}
        toggleButtonCF?.setOnClickListener {v: View -> onSwitchClick(v)}

        return view
    }

    private fun onButtonClick(v: View) {
        val input = tempC.text.toString()
        var isNumeric: Boolean = true
        var displayTemp: String = ""
        var conversionType: String = ""

        isNumeric = input.matches("-?\\d+(\\.\\d+)?".toRegex())

        if(isNumeric){
            val inputNumber = input.toInt();
            val df = DecimalFormat("#.#")

            if(isCelsius){
                val result = CtoF(inputNumber)
                conversionType = "CtoF"
                displayTemp = df.format(result)
                displayTemp += " F"
            }else{
                val result = FtoC(inputNumber)
                conversionType = "FtoC"
                displayTemp = df.format(result)
                displayTemp += " C"
            }
        }else{
            Log.i(TAG,"That was not a number")
        }

    }
    //changes toggleButton between measurements
    private fun onSwitchClick(view: View) {
        if( isCelsius ){
            toggleButtonCF?.textOn = "To Fahrenheit"
            isCelsius = false
        }else{
            toggleButtonCF?.textOff = "To Celsiuss"
            isCelsius = true
        }

    }
    //Conversion equations

    private fun CtoF(temp: Int): Float{
        return temp * (9f / 5f) + 32
    }

    private fun FtoC(temp: Int): Float{
        return (temp - 32) * (5f / 9f)
    }



}

