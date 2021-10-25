package by.baranovdev.fitnfood.repository

import by.baranovdev.fitnfood.database.UserDatabase
import by.baranovdev.fitnfood.database.entity.Program
import by.baranovdev.fitnfood.database.entity.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
class ProgramRepository(
    private val database: UserDatabase
) {

    private val dao = database.programDao()
    private val ioScope = CoroutineScope(Dispatchers.IO)

    fun insert(program: Program) {
        ioScope.launch { dao.insert(program) }
    }

    suspend fun loadAll():List<Program> {
        return dao.getAll()
    }
    suspend fun deleteAll() {
        return dao.deleteAll()
    }
}
