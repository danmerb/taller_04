package com.example.android.Biblioteca.Room.Entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Favorite")
data class Favorite(@PrimaryKey @ColumnInfo(name = "Favorite") val word: String)
