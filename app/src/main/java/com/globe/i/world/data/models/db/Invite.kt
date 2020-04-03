package com.globe.i.world.data.models.db

import androidx.room.*
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "invites",
    indices = [Index(value = ["sender_id","receiver_id"])],
    foreignKeys = [
        ForeignKey(entity = User::class,
            parentColumns = ["user_id"],
            childColumns = ["sender_id"],
            onDelete = ForeignKey.NO_ACTION),

        ForeignKey(entity = User::class,
            parentColumns = ["user_id"],
            childColumns = ["receiver_id"],
            onDelete = ForeignKey.NO_ACTION)
    ])
data class Invite(

    @Expose
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Int?,

    @Expose
    @SerializedName("sender_id")
    @ColumnInfo(name = "sender_id")
    val senderId:Long,

    @Expose
    @SerializedName("receiver_id")
    @ColumnInfo(name = "receiver_id")
    val receiver_id:Long,

    @Expose
    @SerializedName("created_at")
    @ColumnInfo(name = "created_at")
    var createdAt: Long = System.currentTimeMillis(),

    @Expose
    @SerializedName("update_at")
    @ColumnInfo(name = "update_at")
    var updatedAt: Long = System.currentTimeMillis()

) {
    constructor():this(null,0,0,createdAt = 0,updatedAt = 0)
}

/*
    query class for join when fetching all invites
    todo::add user receiver and sender columns
 */
data class InviteTuples(
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?
)
