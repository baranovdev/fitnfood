package by.baranovdev.fitnfood.database.dao
import androidx.room.*
import by.baranovdev.fitnfood.database.entity.Exercise


@Dao
interface ExerciseDao {

    @Insert
    fun insert(exercise: Exercise)

    @Query("SELECT * FROM user_table")
    suspend fun getAll(): List<Exercise>
}