package com.globe.i.world.data.models.db

import androidx.room.Embedded
import androidx.room.Relation

data class GroupMembers(
    //get the information
    @Embedded val group: Group,
    @Relation(
        parentColumn ="group_id",
        entityColumn = "user_id"
    )
    val members:List<User>
)