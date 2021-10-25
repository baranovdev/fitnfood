package by.baranovdev.fitnfood.activities.ui.infocollector

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import by.baranovdev.fitnfood.database.entity.User
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class InfoCollectorViewModel(application: Application) : AndroidViewModel(application) {

    var databaseRef = FirebaseDatabase.getInstance().getReference("users")

    private val auth = Firebase.auth

    var nameC = "Name"
    var difficultyC = 0
    var uid = ""
    var id = ""

    fun createUser():User{
        var newUser : User? = null
        uid = auth.currentUser?.uid ?: "uid"
        id = databaseRef.key ?: "23"
        newUser = User(nameC, difficultyC)
        databaseRef.push().setValue(newUser)
        return newUser
    }


}