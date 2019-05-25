package com.example.android.Biblioteca.Room.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "bookXeditorial", foreignKeys = [
    ForeignKey(entity = Editorial::class, parentColumns = ["id_editorial"], childColumns = ["id_editorial"]),
    ForeignKey(entity = Book::class, parentColumns = ["book_isbn"], childColumns = ["id_book"])
])
data class BookXEditorial(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id_bxe") val id_bxe: Int?=0,
                       @ColumnInfo(name = "id_book") val id_book: Int,
                       @ColumnInfo(name = "id_editorial") val id_editorial: Int)