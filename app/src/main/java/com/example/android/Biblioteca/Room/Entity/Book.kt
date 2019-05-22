package com.example.android.Biblioteca.Room.Entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Book")
data class Book(@PrimaryKey  @ColumnInfo(name = "book_isbn") val isbn: Int,
                @ColumnInfo(name = "book_titleEnglish") val titleEnglish: String,
                @ColumnInfo(name = "book_titleSpanish") val titleSpanish: String,
                @ColumnInfo(name = "book_caratula") val caratula: String,
                @ColumnInfo(name = "book_edition") val edition: String,
                @ColumnInfo(name = "book_editorial") val editorial: String,
                @ColumnInfo(name = "id_author") val Author: Int,
                @ColumnInfo(name = "book_estado") val estado: Boolean,
                @ColumnInfo(name = "id_tags") val tag: Int,
                @ColumnInfo(name = "book_resumeEnglish") val resumeEnglish: String,
                @ColumnInfo(name = "book_resumeSpanish") val resumeSpanish: String)


