package by.baranovdev.fitnfood.repository

import by.baranovdev.fitnfood.database.UserDatabase
import by.baranovdev.fitnfood.database.entity.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRepository(
    private val database: UserDatabase
) {

    private val dao = database.userDao()
    private val ioScope = CoroutineScope(Dispatchers.IO)

    fun insert(user: User) {
        ioScope.launch { dao.insert(user) }
    }

    suspend fun loadAll():List<User> {
        return dao.getAll()
    }
}
