package com.globe.i.world.data.local.db.dao

import androidx.room.*
import com.globe.i.world.data.models.db.Invite

@Dao
interface InviteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(invite: Invite)

    @Delete()
    fun delete(invite: Invite)

    @Update()
    fun update(invite:Invite)

    @Query("SELECT * FROM invites WHERE id = :inviteId")
    fun getInviteById(inviteId:Long)

//   get all invite of current user
    @Query("Select * FROM invites INNER JOIN users ON users.id = invites.id WHERE receiver_id = :userId")
    fun getAllCurrentUserInvites(userId:Long)

}