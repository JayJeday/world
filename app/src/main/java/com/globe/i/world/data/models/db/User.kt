package com.globe.i.world.data.models.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "users")
 data class User(

    @Expose
    @ColumnInfo(name = "user_id")
    @PrimaryKey(autoGenerate = true)
    val userId: Int?,

    @Expose
    @ColumnInfo(name = "email")
    var email: String,

    @Expose
    @SerializedName("username")
    @ColumnInfo(name = "username")
    var username: String,

    @Expose
    @SerializedName("picture_url")
    @ColumnInfo(name = "picture_url")
    var picture: String?,

    @Expose
    @SerializedName("created_at")
    @ColumnInfo(name = "created_at")
    var createdAt: Long,

    @Expose
    @SerializedName("update_at")
    @ColumnInfo(name = "update_at")
    var updatedAt: Long
){
   constructor():this(null,"","",null,0,0)
}