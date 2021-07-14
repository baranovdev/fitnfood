package by.baranovdev.fitnfood.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import by.baranovdev.fitnfood.database.dao.ExerciseDao
import by.baranovdev.fitnfood.database.entity.Exercise

@Database(entities = [Exercise::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): ExerciseDao

    companion object {
        private var INSTANCE: UserDatabase? = null

        fun isCreated(): Boolean {
            return INSTANCE != null
        }

        fun getDatabase(context: Context): UserDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, UserDatabase::class.java, "database").build()
            }
            return INSTANCE as UserDatabase
        }
    }
}