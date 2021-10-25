package by.baranovdev.fitnfood.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import by.baranovdev.fitnfood.database.entity.Program


@Dao
interface ProgramDao {

    @Insert
    fun insert(program: Program)

    @Query("SELECT * FROM program_table")
    suspend fun getAll(): List<Program>

    @Query("DELETE FROM program_table")
    suspend fun deleteAll()


}