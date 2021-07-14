package by.baranovdev.fitnfood.activities.ui.infocollector

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.NumberPicker
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.baranovdev.fitnfood.R


class InfoCollectorWeightFragment : Fragment() {

    private lateinit var viewModel: InfoCollectorViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info_collector_weight, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(InfoCollectorViewModel::class.java)

        val numberPicker = view.findViewById<NumberPicker>(R.id.picker_weight)
        val measurePicker = view.findViewById<NumberPicker>(R.id.picker_weight_measure)
        val measure = arrayOf("kg","lb")
        val button = view.findViewById<Button>(R.id.button_collector_to_gender)

        measurePicker?.minValue = 0
        measurePicker?.maxValue = measure.size - 1
        measurePicker?.wrapSelectorWheel = false
        measurePicker?.displayedValues = measure

        numberPicker?.minValue = 30
        numberPicker?.maxValue = 150
        numberPicker?.wrapSelectorWheel = false

        numberPicker?.setOnValueChangedListener { picker, oldVal, newVal ->
            if(measurePicker?.value==0) viewModel.weightC = newVal.toString().toInt()
            else viewModel.weightC = (newVal.toString().toDouble() / 1000 * 454).toInt()
        }

        measurePicker?.setOnValueChangedListener { picker, oldVal, newVal ->
            if(newVal==0) viewModel.weightC = numberPicker?.value.toString().toInt()
            else viewModel.weightC = (numberPicker?.value.toString().toDouble() / 1000 * 454).toInt()
        }

        button?.setOnClickListener{
            findNavController().navigate(R.id.show_collector_gender)
        }



    }
}