package by.baranovdev.fitnfood.repository

import by.baranovdev.fitnfood.database.UserDatabase
import by.baranovdev.fitnfood.database.entity.Exercise
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRepository(
    private val database: UserDatabase
) {

    private val dao = database.userDao()
    private val ioScope = CoroutineScope(Dispatchers.IO)

    fun insert(exercise: Exercise) {
        ioScope.launch { dao.insert(exercise) }
    }

    suspend fun loadAll():List<Exercise> {
        return dao.getAll()
    }
}
