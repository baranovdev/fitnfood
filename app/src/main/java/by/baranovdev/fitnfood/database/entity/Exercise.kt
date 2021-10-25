package by.baranovdev.fitnfood.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise_table")
data class Exercise(
    val name: String?,
    val url : String?,
    val key :String?
){
    @PrimaryKey(autoGenerate = true)
    var id :Int? = null
}