package com.loading.xcall.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideBlacklistRepository(dao: BlacklistDao): BlacklistRepository = BlacklistRepository(dao)

    @Provides
    @Singleton
    fun provideWhitelistRepository(dao: WhitelistDao): WhitelistRepository = WhitelistRepository(dao)

    @Provides
    @Singleton
    fun provideBlockedCallLogRepository(dao: BlockedCallLogDao): BlockedCallLogRepository = BlockedCallLogRepository(dao)
} 