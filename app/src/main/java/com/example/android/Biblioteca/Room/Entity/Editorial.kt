package com.example.android.Biblioteca.Room.Entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Editorial")
data class Editorial(@PrimaryKey @ColumnInfo(name = "Editorial") val word: String)
