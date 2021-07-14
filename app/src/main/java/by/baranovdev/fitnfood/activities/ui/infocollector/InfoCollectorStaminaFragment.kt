package by.baranovdev.fitnfood.activities.ui.infocollector

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.NumberPicker
import androidx.lifecycle.ViewModelProvider
import by.baranovdev.fitnfood.R
import by.baranovdev.fitnfood.activities.MainActivity
import by.baranovdev.fitnfood.database.UserDatabase


class InfoCollectorStaminaFragment : Fragment() {

    lateinit var viewModel : InfoCollectorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info_collector_stamina, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(InfoCollectorViewModel::class.java)
        val numberPicker = view.findViewById<NumberPicker>(R.id.picker_stamina)

        numberPicker.minValue = 0
        numberPicker.maxValue = 100

        val button = view.findViewById<Button>(R.id.button_collector_finish)

        button.setOnClickListener{
            viewModel.staminaC = numberPicker.value.toString().toInt()
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }


    }

}