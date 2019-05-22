package com.example.android.Biblioteca.Room.Entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Book")
data class Book(@PrimaryKey @ColumnInfo(name = "Book") val word: String)
