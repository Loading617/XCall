package com.loading.xcall.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete

@Dao
interface BlockedCallLogDao {
    @Query("SELECT * FROM blocked_call_log ORDER BY date DESC")
    suspend fun getAll(): List<BlockedCallLogEntry>

    @Insert
    suspend fun insert(entry: BlockedCallLogEntry)

    @Delete
    suspend fun delete(entry: BlockedCallLogEntry)
} 