package by.baranovdev.fitnfood.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import by.baranovdev.fitnfood.database.dao.ProgramDao
import by.baranovdev.fitnfood.database.dao.UserDao
import by.baranovdev.fitnfood.database.entity.Program
import by.baranovdev.fitnfood.database.entity.User

@Database(entities = [Program::class, User::class], version = 3)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun programDao(): ProgramDao

    companion object {
        private var INSTANCE: UserDatabase? = null

        fun isCreated(): Boolean {
            return INSTANCE != null
        }

        fun getDatabase(context: Context): UserDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, UserDatabase::class.java, "app_database").build()
            }
            return INSTANCE as UserDatabase
        }
    }
}