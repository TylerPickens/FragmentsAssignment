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
import com.ebookfrenzy.assignment4fragments.R.layout.length_fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.length_fragment.*
import kotlinx.android.synthetic.main.temp_fragment.*
import kotlinx.android.synthetic.main.temp_fragment.view.*
import java.text.DecimalFormat

class LengthFragment : Fragment(){
    var isMeters = true
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
        val view = inflater?.inflate(length_fragment, container, false)
        val buttonFM: Button? = view?.findViewById(R.id.buttonFM)
        val toggleButtonFM: ToggleButton? = view?.findViewById(R.id.toggleButtonFM)

        buttonFM?.setOnClickListener {v: View -> onButtonClick(v)}
        toggleButtonFM?.setOnClickListener {v: View -> onSwitchClick(v)}

        return view
    }

    private fun onButtonClick(v: View) {
        val input = lengthFM.text.toString()
        var isNumeric: Boolean = true
        var displayLength: String = ""
        var conversionType: String = ""

        isNumeric = input.matches("-?\\d+(\\.\\d+)?".toRegex())

        if(isNumeric){
            val inputNumber = input.toInt();
            val df = DecimalFormat("#.#")

            if(isMeters){
                val result = MtoF(inputNumber)
                conversionType = "MtoF"
                displayLength = df.format(result)
                displayLength += " F"
                textViewFM.text=displayLength
            }else{
                val result = FtoM(inputNumber)
                conversionType = "FtoM"
                displayLength = df.format(result)
                displayLength += " M"
                textViewFM.text=displayLength
            }
        }else{
            Log.i(TAG,"That was not a number")
        }

    }
    //changes toggleButton between measurements
    private fun onSwitchClick(view: View) {
        if( isMeters ){
            toggleButtonCF?.textOn = "To Feet"
            isMeters = false
        }else{
            toggleButtonCF?.textOff = "To Meters"
            isMeters = true
        }

    }
    //Conversion equations

    private fun MtoF(length: Int): Float{
        return (length) * 3.3f
    }
    private fun FtoM(length: Int): Float{
        return (length) / 3.3f
    }



}

