package by.baranovdev.fitnfood.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import by.baranovdev.fitnfood.R
import by.baranovdev.fitnfood.databinding.ActivityAuthBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class AuthActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        Firebase.database("https://fit-n-food-d756c-default-rtdb.europe-west1.firebasedatabase.app")

        val intentCollector = Intent(this, InfoCollectorActivity::class.java)
        val intentMain = Intent(this, MainActivity::class.java)
        auth = Firebase.auth
        val emailInput = binding.inputEmailEditText
        val passwordInput = binding.inputPasswordEditText


        binding.authorizationButtonSignUp.setOnClickListener {



            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()
            if (email.isEmpty() || password.isEmpty()) Toast.makeText(
                this,
                "ERROR",
                Toast.LENGTH_SHORT
            ).show()
            else {
                auth.createUserWithEmailAndPassword(
                    email,
                    password
                ).addOnCompleteListener(this) {
                    if (it.isSuccessful) {

                        startActivity(intentCollector)
                    } else {
                        Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()

                    }
                }
            }
        }

        findViewById<Button>(R.id.authorization_button_sign_in).setOnClickListener {

            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()
            if (email.isEmpty() || password.isEmpty()) Toast.makeText(
                this,
                "ERROR",
                Toast.LENGTH_SHORT
            ).show()
            auth.signInWithEmailAndPassword(
                email,
                password
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    val reference = FirebaseDatabase.getInstance().reference
                    reference.child("user").setValue("1")
                    startActivity(intentMain)
                } else {
                    Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}