package com.loading.xcall.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete

@Dao
interface WhitelistDao {
    @Query("SELECT * FROM whitelist")
    suspend fun getAll(): List<WhitelistEntry>

    @Insert
    suspend fun insert(entry: WhitelistEntry)

    @Delete
    suspend fun delete(entry: WhitelistEntry)

    @Query("SELECT * FROM whitelist WHERE phoneNumber = :number LIMIT 1")
    suspend fun findByNumber(number: String): WhitelistEntry?
} 