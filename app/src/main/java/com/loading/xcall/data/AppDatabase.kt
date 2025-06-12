package com.loading.xcall.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [BlacklistEntry::class, WhitelistEntry::class, BlockedCallLogEntry::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun blacklistDao(): BlacklistDao
    abstract fun whitelistDao(): WhitelistDao
    abstract fun blockedCallLogDao(): BlockedCallLogDao
} 