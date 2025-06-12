package com.loading.xcall.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "blocked_call_log")
data class BlockedCallLogEntry(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String?,
    val phoneNumber: String,
    val date: String
) 