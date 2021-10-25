package by.baranovdev.fitnfood.activities.ui.home

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.baranovdev.fitnfood.database.UserDatabase
import by.baranovdev.fitnfood.database.entity.Program
import by.baranovdev.fitnfood.parser.FirestoreParser
import by.baranovdev.fitnfood.repository.ProgramRepository
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val programRepository = ProgramRepository(UserDatabase.getDatabase(application))
    val db = Firebase.firestore
    private val _programListLiveData = MutableLiveData<MutableList<Program>>()
    val programListLiveData: LiveData<MutableList<Program>> = _programListLiveData
    private val ioScope = CoroutineScope(Dispatchers.IO)


    fun setNewProgramList(list : MutableList<Program>){
        _programListLiveData.value = list
    }

    fun loadAll() {
        ioScope.launch {
            val programList = programRepository.loadAll()
            val arrayList = ArrayList<Program>()
            arrayList.addAll(programList)
            _programListLiveData.postValue(arrayList)
        }
    }

    fun updateDatabase() {
        ioScope.async {
            programRepository.deleteAll()
            var tempProgram:Program
            val programList = ArrayList<Program>()
            db.collection("program")
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        tempProgram = FirestoreParser.fromProgramResponseToProgram(document.data, document.id)
                        programRepository.insert(tempProgram)
                        programList.add(tempProgram)
                        _programListLiveData.postValue(programList)
                    }
                    _programListLiveData.postValue(programList)
                }
                .addOnFailureListener {
                    Toast.makeText(getApplication(),it.message.toString(), Toast.LENGTH_SHORT).show()
                }
        }
    }
}