package com.globe.i.world.data.models.db

import android.location.Address

data class Place(var name:String = "", val address: String ="", val rating:String ="") {

    constructor():this("","","")
}