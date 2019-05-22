package com.example.android.Biblioteca.Room.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "Editorial")
data class Author(@PrimaryKey @ColumnInfo(name = "id_author") val id: Int,
                  @ColumnInfo(name = "Author_name") val name: String )

