package com.globe.i.world.data.models.db

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class UserFetchGroups(
    @Embedded
    val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "groupId",
        associateBy = Junction(UserGroups::class)
    )
     val group: List<Group>
)
