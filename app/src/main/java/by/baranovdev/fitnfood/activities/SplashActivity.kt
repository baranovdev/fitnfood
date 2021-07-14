package by.baranovdev.fitnfood.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.baranovdev.SharedPrefID
import by.baranovdev.fitnfood.activities.ui.infocollector.InfoCollectorViewModel
import by.baranovdev.fitnfood.database.UserDatabase
import by.baranovdev.fitnfood.repository.UserRepository

class SplashActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intentHome = Intent(this, MainActivity::class.java)
        val intentCollectInfo = Intent(this, InfoCollectorActivity::class.java)

        val repos = UserRepository(UserDatabase.getDatabase(application))

        if(getSharedPreferences(
                SharedPrefID
                    .APP_PREFERENCES, MODE_PRIVATE)
                    .getBoolean(SharedPrefID.APP_PREFERENCES_USER_CHECKED, false))
                        startActivity(intentHome)
        else startActivity(intentCollectInfo)

        finish()
    }
}