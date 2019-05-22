package com.example.android.Biblioteca.Room.Entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "AuthorXBook")
data class AuthorXBook(@PrimaryKey @ColumnInfo(name = "AuthorxBook") val word: String)
