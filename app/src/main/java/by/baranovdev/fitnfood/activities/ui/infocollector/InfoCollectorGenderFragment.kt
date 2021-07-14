package by.baranovdev.fitnfood.activities.ui.infocollector

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.NumberPicker
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import by.baranovdev.fitnfood.R

class InfoCollectorGenderFragment : Fragment() {

    private lateinit var viewModel: InfoCollectorViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info_collector_gender, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(InfoCollectorViewModel::class.java)

        val numberPicker = view.findViewById<NumberPicker>(R.id.picker_gender)
        val genders = arrayOf("male","female")



        numberPicker?.minValue = 0
        numberPicker?.maxValue = genders.size - 1
        numberPicker?.wrapSelectorWheel = false
        numberPicker?.displayedValues = genders


        numberPicker?.setOnValueChangedListener { picker, oldVal, newVal ->
            viewModel.isManC = picker.value==0
        }

        view.findViewById<Button>(R.id.button_collector_to_stamina)?.setOnClickListener{
            findNavController().navigate(R.id.show_collector_stamina)
        }


    }

}