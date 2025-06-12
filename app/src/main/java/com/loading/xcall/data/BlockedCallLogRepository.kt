package com.loading.xcall.data

class BlockedCallLogRepository(private val dao: BlockedCallLogDao) {
    suspend fun getAll() = dao.getAll()
    suspend fun insert(entry: BlockedCallLogEntry) = dao.insert(entry)
    suspend fun delete(entry: BlockedCallLogEntry) = dao.delete(entry)
} 