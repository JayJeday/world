package com.globe.i.world.data.local.db.dao

import androidx.room.*
import com.globe.i.world.data.models.db.Trip


@Dao
interface TripDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(trip: Trip)
    
    @Update
    fun update(trip: Trip)

    @Delete
    fun delete(trip: Trip)
}