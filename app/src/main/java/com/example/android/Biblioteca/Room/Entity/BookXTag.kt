package com.example.android.Biblioteca.Room.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "bookXtag", foreignKeys = [
    ForeignKey(entity = Tag::class, parentColumns = ["id_tag"], childColumns = ["id_tag"]),
    ForeignKey(entity = Book::class, parentColumns = ["book_isbn"], childColumns = ["id_book"])
])
data class BookXTag(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id_bxt") val id_bxt: Int?=0,
                       @ColumnInfo(name = "id_book") val id_book: Int,
                       @ColumnInfo(name = "id_tag") val id_tag: Int)