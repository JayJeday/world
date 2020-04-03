package com.globe.i.world.data.models.db

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

/*
    user groups
 */
@Entity(primaryKeys = ["userId", "groupId"])
data class UserGroups(
    val userId: Long,
    val groupId: Long
)