package com.example.android.Biblioteca.Room.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "BookXAuthor", foreignKeys = [
    ForeignKey(entity = Author::class, parentColumns = ["id_author"], childColumns = ["id_author"]),
    ForeignKey(entity = Book::class, parentColumns = ["book_isbn"], childColumns = ["id_book"])
])
data class BookXAuthor(@PrimaryKey (autoGenerate = true) @ColumnInfo(name = "id_bxa") val id_bxa: Int?=0,
                  @ColumnInfo(name = "id_book") val id_book: Int,
                  @ColumnInfo(name = "id_author") val id_author: Int)
