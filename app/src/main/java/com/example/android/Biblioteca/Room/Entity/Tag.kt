package com.example.android.Biblioteca.Room.Entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Tag")
data class Tag(@PrimaryKey @ColumnInfo(name = "Tag") val word: String)
