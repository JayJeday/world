package com.globe.i.world.data.models.db

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class GroupFetchMembers(
    @Embedded
    val group: Group,
    @Relation(
        parentColumn = "groupId",
        entityColumn = "userId",
        associateBy = Junction(UserGroups::class)
    )
    val user:List<User>
)
