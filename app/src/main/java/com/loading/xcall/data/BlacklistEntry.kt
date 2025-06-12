package com.loading.xcall.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "blacklist")
data class BlacklistEntry(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String?,
    val phoneNumber: String
) 