package com.example.android.Biblioteca.Room.Entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Tag")
data class Tag(@PrimaryKey @ColumnInfo(name = "id_tag") val id: Int,
               @ColumnInfo(name = "Taf_name") val name: String ,
               @ColumnInfo(name = "id_book") val id_book: Int)
