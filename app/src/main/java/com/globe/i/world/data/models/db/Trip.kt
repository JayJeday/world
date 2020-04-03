package com.globe.i.world.data.models.db

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "trips")
data class Trip(
    @Expose
    @ColumnInfo(name = "id")
    @PrimaryKey
    val id: Int = 0,

    @Expose
    @ColumnInfo(name = "title")
    val title: String? = null,

    @Expose
    @SerializedName("is_completed")
    @ColumnInfo(name = "is_completed")
    val isCompleted: Boolean = false,

    @Expose
    @SerializedName("trip_time")
    @ColumnInfo(name = "trip_time")
    val tripTime: Long = System.currentTimeMillis(),

    @Expose
    @SerializedName("created_at")
    @ColumnInfo(name = "created_at")
    val createdAt: Long = System.currentTimeMillis(),

    @Expose
    @SerializedName("updated_at")
    @ColumnInfo(name = "updated_at")
    val updatedAt: Long = System.currentTimeMillis(),

    @Expose
    @SerializedName("place")
    @Embedded
    val place:Place
) {
    constructor():this(0, "", false, 0, 0, 0,place=Place()){
    }
}