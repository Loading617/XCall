package com.loading.xcall.data.lookup

import android.content.Context
import android.net.Uri
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class ExportImportManager(private val context: Context) {

    fun exportNumbers(numbers: List<String>, uri: Uri): Boolean {
        return try {
            context.contentResolver.openOutputStream(uri)?.use { outputStream ->
                OutputStreamWriter(outputStream).use { writer ->
                    numbers.forEach { number ->
                        writer.write("$number\n")
                    }
                }
            }
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    fun importNumbers(uri: Uri): List<String> {
        val importedNumbers = mutableListOf<String>()
        try {
            context.contentResolver.openInputStream(uri)?.use { inputStream ->
                BufferedReader(InputStreamReader(inputStream)).useLines { lines ->
                    lines.forEach { line ->
                        val cleanNumber = line.trim()
                        if (cleanNumber.isNotEmpty()) {
                            importedNumbers.add(cleanNumber)
                        }
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return importedNumbers
    }
}
