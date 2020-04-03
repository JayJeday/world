package com.globe.i.world.data.local.db.dao

import androidx.room.*
import com.globe.i.world.data.models.db.User
import com.globe.i.world.data.models.db.UserFetchOwnedGroups
import com.globe.i.world.data.models.db.UserGroups

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(vararg users: User)


    fun insertWithTimestamp(user: User) {
        insert(user.apply{
            createdAt = System.currentTimeMillis()
            updatedAt = System.currentTimeMillis()
        })
    }

    @Update
    fun update(user: User)

    fun updateWithTimestamp(user: User){
        update(user.apply {
            updatedAt = System.currentTimeMillis()
        })
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<User>)

    @Delete
    fun delete(users: List<User>)

    @Update
    fun updateUsers(users: List<User>)

    @Query("SELECT * FROM users")
    fun loadAllUsers(): List<User>

    @Query("SELECT * FROM users WHERE user_id = :userId")
    fun loadUser(userId:Long):User

    //get all user created groups transaction ensure that the whole operation is performed atomically
    @Transaction
    @Query("SELECT * FROM User WHERE user_id = :userId")
    fun getUserOwnedGroups(userId:Long): List<UserFetchOwnedGroups>

}