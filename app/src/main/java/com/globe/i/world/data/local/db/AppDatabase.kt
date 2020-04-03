package com.globe.i.world.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.globe.i.world.data.local.db.dao.GroupDao
import com.globe.i.world.data.local.db.dao.InviteDao
import com.globe.i.world.data.local.db.dao.TripDao
import com.globe.i.world.data.local.db.dao.UserDao
import com.globe.i.world.data.models.db.Group
import com.globe.i.world.data.models.db.Invite
import com.globe.i.world.data.models.db.Trip
import com.globe.i.world.data.models.db.User
import java.util.*


@Database(entities = [User::class,Trip::class,Invite::class, Group::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    //dao called here
    abstract fun userDataDao(): UserDao
    abstract fun tripDataDao(): TripDao
    abstract fun groupDataDao(): GroupDao
    abstract fun inviteDataDao(): InviteDao

    //TODO::change this when dagger is implemented
    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase::class.java, "world.db"
                        ).allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}