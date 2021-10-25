package by.baranovdev.fitnfood.activities.ui.infocollector

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.baranovdev.fitnfood.R
import com.google.android.material.textfield.TextInputLayout

class InfoCollectorNameFragment : Fragment() {

    private lateinit var viewModel: InfoCollectorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_info_collector_name, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(InfoCollectorViewModel::class.java)

        val nameInput = view.findViewById<TextInputLayout>(R.id.collector_name)
        val button = view.findViewById<Button>(R.id.button_collector_to_age)

        button?.setOnClickListener {
            if (nameInput.editText?.text.toString().trim().isEmpty()) nameInput.error =
                "Should not be empty"
            else {
                viewModel.nameC = nameInput?.editText?.text.toString()
                findNavController().navigate(R.id.show_collector_difficulty)
            }
        }

    }

}