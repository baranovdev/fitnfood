package by.baranovdev.fitnfood.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import by.baranovdev.SharedPrefID
import by.baranovdev.SharedPrefID.APP_PREFERENCES
import by.baranovdev.fitnfood.R
import by.baranovdev.fitnfood.database.UserDatabase
import by.baranovdev.fitnfood.repository.UserRepository
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        setContentView(R.layout.activity_start)
        val intentHome = Intent(this, MainActivity::class.java)
        val intentAuth = Intent(this, AuthActivity::class.java)
        val auth = Firebase.auth
        val currentUser = auth.currentUser


//        if (currentUser != null) {
//            startActivity(intentHome)
//        } else
            startActivity(intentAuth)
        finish()
    }
}