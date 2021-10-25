package by.baranovdev.fitnfood.roomrepository

import by.baranovdev.fitnfood.database.entity.User
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


abstract class RoomRepository() {
    companion object {

        lateinit var userList: ArrayList<User>
        fun getUsersFromDB(): ArrayList<User> {
            val database = Firebase.database.getReference("users")
            val vListener: ValueEventListener = object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (userList.isNotEmpty()) userList.clear()
                    for (ds in dataSnapshot.children) {
                        val user: User = ds.getValue(User::class.java)!!
                        userList.add(user)
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            }
            database.addValueEventListener(vListener)
            return userList
        }
    }
}
