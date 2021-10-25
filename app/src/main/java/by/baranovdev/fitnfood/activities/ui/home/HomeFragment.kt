package by.baranovdev.fitnfood.activities.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import by.baranovdev.fitnfood.activities.ui.home.recycler.ProgramAdapter
import by.baranovdev.fitnfood.database.entity.Program
import by.baranovdev.fitnfood.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {



        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onStart() {
        super.onStart()

        val recycler = binding.fitRecycler
        recycler.layoutManager = LinearLayoutManager(context)
        homeViewModel.updateDatabase()

        val database = Firebase.database("https://fit-n-food-d756c-default-rtdb.europe-west1.firebasedatabase.app/")
        val myRef = database.getReference("version")

        myRef.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                binding.progressBar.visibility = View.VISIBLE
                homeViewModel.updateDatabase()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(requireContext(), "Failed to read value.", Toast.LENGTH_SHORT).show()
            }

        })


        if(homeViewModel.programListLiveData.value != null) {
            recycler.adapter = ProgramAdapter(homeViewModel.programListLiveData.value as MutableList<Program>)

        }

        homeViewModel.programListLiveData.observe(this){
            recycler.adapter = ProgramAdapter(homeViewModel.programListLiveData.value.orEmpty() as MutableList<Program>)
            binding.progressBar.visibility = View.GONE
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}