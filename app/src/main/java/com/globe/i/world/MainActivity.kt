package com.globe.i.world

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amitshekhar.DebugDB
import com.globe.i.world.data.local.db.AppDatabase
import com.globe.i.world.data.models.db.User
import com.google.android.gms.maps.SupportMapFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : FragmentActivity() {


    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val worldDatabase = AppDatabase.getInstance(this)
//
        val user = User()
        //generate random number
        val random = Random(10).nextInt(0,1000)
        Log.d("random long number", "number: $random")

        user.username = "test$random"
        user.email = "test@email.com"

        worldDatabase?.userDataDao()?.insertWithTimestamp(user)

        val users  = worldDatabase?.userDataDao()?.loadAllUsers()

        Log.d("data saved", users.toString() + "size" )

        Log.d("debug addr", DebugDB.getAddressLog() + "message")
    }
}
