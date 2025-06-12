package com.loading.xcall.data

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "xcall_db").build()

    @Provides
    fun provideBlacklistDao(db: AppDatabase): BlacklistDao = db.blacklistDao()

    @Provides
    fun provideWhitelistDao(db: AppDatabase): WhitelistDao = db.whitelistDao()

    @Provides
    fun provideBlockedCallLogDao(db: AppDatabase): BlockedCallLogDao = db.blockedCallLogDao()
} 