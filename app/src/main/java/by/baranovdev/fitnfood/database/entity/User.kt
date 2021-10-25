package by.baranovdev.fitnfood.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
class User(
    @ColumnInfo(name = "user_name")
    val name: String?,
    @ColumnInfo(name = "user_difficulty")
    val difficulty: Int?
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="user_id")
    var id: Int? = null
}