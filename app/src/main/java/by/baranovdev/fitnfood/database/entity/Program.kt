package by.baranovdev.fitnfood.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import by.baranovdev.fitnfood.parser.FirestoreParser

@Entity(tableName = "program_table")
data class Program(

    @ColumnInfo(name="program_name")
    val name : String?,
    @ColumnInfo(name="program_xp")
    val xp : Int?,
    @ColumnInfo(name="program_icon_url")
    val iconUrl : String?,
    @ColumnInfo(name="program_repeats")
    val repeats : Int?,
    @ColumnInfo(name="program_exercise_list")
    val exerciseListString : String?,
    @ColumnInfo(name="program_description")
    val description : String?,
    @ColumnInfo(name="program_key")
    val key :String?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}