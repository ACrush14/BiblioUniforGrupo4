package com.example.bibliounifor.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "livros")
data class EntidadeLivro(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val author: String,
    val content: String,
    val coverResourceId: Int = 0,
    val category: String = "",
    val isbn: String = "",
    val isAvailable: Boolean = true
)
