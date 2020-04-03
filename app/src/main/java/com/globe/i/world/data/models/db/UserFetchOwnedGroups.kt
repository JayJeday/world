package com.globe.i.world.data.models.db

import androidx.room.Embedded
import androidx.room.Relation

data class UserFetchOwnedGroups(
    @Embedded
    val user: User,
    @Relation(
        parentColumn = "user_id",
        entityColumn = "admin_user_id"
    )
    val group: List<Group>
)