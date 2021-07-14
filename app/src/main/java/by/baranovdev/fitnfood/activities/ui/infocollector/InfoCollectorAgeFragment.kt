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

class InfoCollectorAgeFragment : Fragment() {

    private lateinit var viewModel: InfoCollectorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info_collector_age, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(InfoCollectorViewModel::class.java)

        val numberPicker = view.findViewById<NumberPicker>(R.id.picker_age)
        val button = view.findViewById<Button>(R.id.button_collector_to_gender)

        numberPicker.minValue = 10
        numberPicker.maxValue = 70

        button.setOnClickListener{
            viewModel.ageC = numberPicker.value.toString().toInt()
            findNavController().navigate(R.id.show_collector_weight)
        }


    }


}