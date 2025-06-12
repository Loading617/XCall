package com.loading.xcall.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "whitelist")
data class WhitelistEntry(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val phoneNumber: String
) 