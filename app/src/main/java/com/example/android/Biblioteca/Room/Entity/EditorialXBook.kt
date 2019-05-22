package com.example.android.Biblioteca.Room.Entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "EditorialxBook")
data class EditorialXBook(@PrimaryKey @ColumnInfo(name = "EditorialxBook") val word: String)
