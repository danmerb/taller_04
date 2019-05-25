package com.example.android.Biblioteca.Room.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.android.Biblioteca.Room.Entity.Book
import com.example.android.Biblioteca.Room.Entity.BookXTag


@Dao
interface BookXTagDao {

    //buscar por tag Spanish
    @Query("SELECT * FROM Book INNER JOIN BookXTag  ON Book.book_isbn = BookXTag.id_book  INNER JOIN Tag ON BookXTag.id_tag = Tag.id_tag WHERE Tag.tag_nameSpan= :tag ORDER BY Tag.tag_nameSpan ASC")
    fun getBooksbyTagSpa(tag: String): LiveData<List<Book>>

    //buscar por tag English
    @Query("SELECT * FROM Book INNER JOIN BookXTag  ON Book.book_isbn = BookXTag.id_book  INNER JOIN Tag ON BookXTag.id_tag = Tag.id_tag WHERE Tag.tag_nameEng= :tag ORDER BY Tag.tag_nameEng ASC")
    fun getBooksbyTagEng(tag: String): LiveData<List<Book>>

    @Insert
    suspend fun insert(bookrXtag: BookXTag)

    @Query("DELETE FROM bookXtag")
    fun deleteAll()
}