package com.loading.xcall.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete

@Dao
interface BlacklistDao {
    @Query("SELECT * FROM blacklist")
    suspend fun getAll(): List<BlacklistEntry>

    @Insert
    suspend fun insert(entry: BlacklistEntry)

    @Delete
    suspend fun delete(entry: BlacklistEntry)

    @Query("SELECT * FROM blacklist WHERE phoneNumber = :number LIMIT 1")
    suspend fun findByNumber(number: String): BlacklistEntry?
} 