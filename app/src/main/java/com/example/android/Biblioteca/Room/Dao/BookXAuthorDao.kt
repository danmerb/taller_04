package com.example.android.Biblioteca.Room.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.android.Biblioteca.Room.Entity.Book
import com.example.android.Biblioteca.Room.Entity.BookXAuthor

@Dao
interface BookXAuthorDao {

    //buscar por autor
    @Query("SELECT * FROM Book INNER JOIN BookXAuthor ON BookXAuthor.id_book == Book.book_isbn   INNER JOIN Author ON BookXAuthor.id_author = Author.id_author WHERE Author.Author_name= :authorsearch ORDER BY Author.Author_name ASC")
    fun getBooksbyAuthor(authorsearch: String): LiveData<List<Book>>

    @Insert
    suspend fun insert(bookrXautor: BookXAuthor)

    @Query("DELETE FROM BookXAuthor")
    fun deleteAll()
}