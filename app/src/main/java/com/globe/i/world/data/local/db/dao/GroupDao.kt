package com.globe.i.world.data.local.db.dao

import androidx.room.*
import com.globe.i.world.data.models.db.Group
import com.globe.i.world.data.models.db.GroupFetchMembers
import com.globe.i.world.data.models.db.User
import com.globe.i.world.data.models.db.UserFetchGroups

@Dao
interface GroupDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insert(group: Group)

    @Update
    fun update(group: Group)

    @Delete
    fun delete(group: Group)

    @Query("SELECT * FROM groups")
    fun fetchAllUsers(): List<Group>

    //fetch all user groups
    @Transaction
    @Query("SELECT * FROM User WHERE user_id = :userId")
    fun getUserGroups(userId:Long): List<UserFetchGroups>

    //fetch all groups users
    @Transaction
    @Query("SELECT * FROM groups WHERE group_id = :groupId")
    fun getGroupMembers(groupId:Long): List<GroupFetchMembers>



}