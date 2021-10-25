package by.baranovdev.fitnfood.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.baranovdev.fitnfood.R
import by.baranovdev.fitnfood.databinding.ActivityExerciseBinding

class ExerciseActivity : AppCompatActivity() {

    lateinit var binding : ActivityExerciseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
    }

    override fun onStart() {
        super.onStart()

        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}