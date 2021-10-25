package by.baranovdev.fitnfood.activities.ui.infocollector

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.NumberPicker
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.room.RoomDatabase
import by.baranovdev.fitnfood.R
import by.baranovdev.fitnfood.activities.MainActivity
import by.baranovdev.fitnfood.database.UserDatabase
import by.baranovdev.fitnfood.database.entity.User
import by.baranovdev.fitnfood.repository.UserRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class InfoDifficultyWeightFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private lateinit var viewModel: InfoCollectorViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info_collector_weight, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(InfoCollectorViewModel::class.java)

        val roomDB = UserDatabase.getDatabase(requireContext())
        val repos = UserRepository(roomDB)

        val numberPicker = view.findViewById<NumberPicker>(R.id.picker_weight)
        val button = view.findViewById<Button>(R.id.button_collector_to_gender)

        numberPicker?.minValue = 0
        numberPicker?.maxValue = 5
        numberPicker?.wrapSelectorWheel = false

        auth = Firebase.auth
        val database =
            Firebase.database("https://fit-n-food-d756c-default-rtdb.europe-west1.firebasedatabase.app")

        numberPicker?.setOnValueChangedListener { picker, oldVal, newVal ->
            viewModel.difficultyC = newVal.toString().toInt()
        }
        button?.setOnClickListener {
            val reference = database.reference
            var newUser = User(viewModel.nameC, viewModel.difficultyC)
            var uid = auth.currentUser?.uid ?: "uid"
            repos.insert(newUser)
            reference.child("users").child("${auth.currentUser?.uid}").setValue(newUser)
            startActivity(Intent(requireContext(), MainActivity::class.java))
        }

    }
}