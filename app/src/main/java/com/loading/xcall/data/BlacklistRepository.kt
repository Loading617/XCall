package com.loading.xcall.data

class BlacklistRepository(private val dao: BlacklistDao) {
    suspend fun getAll() = dao.getAll()
    suspend fun insert(entry: BlacklistEntry) = dao.insert(entry)
    suspend fun delete(entry: BlacklistEntry) = dao.delete(entry)
    suspend fun findByNumber(number: String) = dao.findByNumber(number)
} 