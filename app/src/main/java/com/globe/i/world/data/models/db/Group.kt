package com.globe.i.world.data.models.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "groups",
    foreignKeys = [
        ForeignKey(entity = User::class,
            parentColumns = ["user_id"],
            childColumns = ["admin_user_id"],
            onDelete = ForeignKey.NO_ACTION)
    ])
data class Group(
    @Expose
    @ColumnInfo(name = "group_id")
    @PrimaryKey
    val groupId: Long = 0,

    @Expose
    @ColumnInfo(name = "admin_user_id")
    val adminUserId: Long,

    @Expose
    @ColumnInfo(name = "description")
    val description: String? = null,

    @Expose
    @SerializedName("created_at")
    @ColumnInfo(name = "created_at")
    val createdAt: Long = System.currentTimeMillis(),

    @Expose
    @SerializedName("updated_at")
    @ColumnInfo(name = "updated_at")
    val updatedAt: Long = System.currentTimeMillis()
)