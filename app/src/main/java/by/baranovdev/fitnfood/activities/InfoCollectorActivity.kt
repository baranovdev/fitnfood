package by.baranovdev.fitnfood.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.baranovdev.fitnfood.R
import by.baranovdev.fitnfood.databinding.ActivityInfoCollectorBinding


class InfoCollectorActivity : AppCompatActivity() {

    private lateinit var binding :ActivityInfoCollectorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoCollectorBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}