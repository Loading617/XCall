package com.loading.xcall.data

class WhitelistRepository(private val dao: WhitelistDao) {
    suspend fun getAll() = dao.getAll()
    suspend fun insert(entry: WhitelistEntry) = dao.insert(entry)
    suspend fun delete(entry: WhitelistEntry) = dao.delete(entry)
    suspend fun findByNumber(number: String) = dao.findByNumber(number)
} 