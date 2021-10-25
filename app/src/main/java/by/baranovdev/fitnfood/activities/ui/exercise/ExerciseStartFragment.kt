package by.baranovdev.fitnfood.activities.ui.exercise

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.baranovdev.fitnfood.R
import by.baranovdev.fitnfood.activities.MainActivity
import by.baranovdev.fitnfood.databinding.ActivityMainBinding
import by.baranovdev.fitnfood.databinding.FragmentExerciseStartBinding
import by.baranovdev.fitnfood.databinding.FragmentHomeBinding
import com.google.android.material.bottomappbar.BottomAppBar

class ExerciseStartFragment : Fragment() {


    private var _binding: FragmentExerciseStartBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExerciseStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        val navBar = requireActivity().findViewById<BottomAppBar>(R.id.nav_view)
        navBar.visibility = View.GONE

    }
}