package by.baranovdev.fitnfood.activities

import android.content.Context
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import by.baranovdev.SharedPrefID
import by.baranovdev.fitnfood.R
import by.baranovdev.fitnfood.activities.ui.infocollector.InfoCollectorViewModel
import by.baranovdev.fitnfood.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    lateinit var viewModelInfo: InfoCollectorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModelInfo = ViewModelProvider(this).get(InfoCollectorViewModel::class.java)

        val sharedPref = getSharedPreferences(SharedPrefID.APP_PREFERENCES, Context.MODE_PRIVATE);

        with(viewModelInfo.createUser()){
            val editor = sharedPref.edit()
            editor.putString(SharedPrefID.APP_PREFERENCES_NAME, name!!)
            editor.putInt(SharedPrefID.APP_PREFERENCES_AGE, age!!)
            editor.putInt(SharedPrefID.APP_PREFERENCES_WEIGHT, weight!!)
            editor.putBoolean(SharedPrefID.APP_PREFERENCES_IS_MAN, isMan!!)
            editor.putInt(SharedPrefID.APP_PREFERENCES_STAMINA, stamina)
            editor.putBoolean(SharedPrefID.APP_PREFERENCES_USER_CHECKED, true)
            editor.commit()
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}