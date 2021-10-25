package by.baranovdev.fitnfood.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import by.baranovdev.SharedPrefID
import by.baranovdev.fitnfood.R
import by.baranovdev.fitnfood.activities.ui.infocollector.InfoCollectorViewModel
import by.baranovdev.fitnfood.database.UserDatabase
import by.baranovdev.fitnfood.database.entity.Exercise
import by.baranovdev.fitnfood.database.entity.Program
import by.baranovdev.fitnfood.databinding.ActivityMainBinding
import by.baranovdev.fitnfood.repository.UserRepository
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.getValue
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    lateinit var viewModelInfo: InfoCollectorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        val intentAuth = Intent(this, AuthActivity::class.java)
        val auth = Firebase.auth
        val currentUser = auth.currentUser

        val ioScope = CoroutineScope(Dispatchers.IO)

        val repos = UserRepository(UserDatabase.getDatabase(application))

        if (currentUser == null) {
            startActivity(intentAuth)
        }

        viewModelInfo = ViewModelProvider(this).get(InfoCollectorViewModel::class.java)

        val sharedPref = getSharedPreferences(SharedPrefID.APP_PREFERENCES, Context.MODE_PRIVATE);

        with(viewModelInfo.createUser()){
            if(this != null) {
                val editor = sharedPref.edit()
                editor.putString(SharedPrefID.APP_PREFERENCES_NAME, name)
                    .putString(SharedPrefID.APP_PREFERENCES_DIFFICULTY, difficulty.toString())
                editor.apply()
            }
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        navView.setupWithNavController(navController)

    }

}