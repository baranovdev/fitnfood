package by.baranovdev.fitnfood.activities.ui.infocollector

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import by.baranovdev.fitnfood.database.entity.Exercise

class InfoCollectorViewModel(application: Application) : AndroidViewModel(application) {

    var nameC = ""
    var weightC = 0
    var ageC = 0
    var isManC = true
    var staminaC = 0

    fun createUser():Exercise{
        return Exercise(nameC, weightC, ageC, isManC, staminaC)
    }


}