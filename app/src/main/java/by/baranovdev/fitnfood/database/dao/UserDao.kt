package by.baranovdev.fitnfood.database.dao
import androidx.room.*
import by.baranovdev.fitnfood.database.entity.User


@Dao
interface UserDao {

    @Insert
    fun insert(user: User)

    @Query("SELECT * FROM user_table")
    suspend fun getAll(): List<User>

    @Query("SELECT * FROM user_table WHERE user_id = :userId")
    suspend fun findUser(userId:String):User
}