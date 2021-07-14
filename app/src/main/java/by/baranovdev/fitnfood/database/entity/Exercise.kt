package by.baranovdev.fitnfood.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
class Exercise(
    @ColumnInfo(name = "exercise_name")
    val name: String?,
    @ColumnInfo(name = "exercise_weight")
    val weight: Int?,
){
    @PrimaryKey(autoGenerate = true)
    var id :Int? = null
}