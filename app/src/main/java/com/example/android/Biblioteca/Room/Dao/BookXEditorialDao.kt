package com.example.android.Biblioteca.Room.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.android.Biblioteca.Room.Entity.Book
import com.example.android.Biblioteca.Room.Entity.BookXEditorial


@Dao
interface BookXEditorialDao {

    //buscar por editorial
    @Query("SELECT * FROM Book INNER JOIN bookXeditorial ON Book.book_isbn = bookXeditorial.id_book  INNER JOIN Editorial ON bookXeditorial.id_editorial = Editorial.id_editorial WHERE Editorial.Editorial_name= :editorialsearch ORDER BY Editorial.Editorial_name ASC")
    fun getBooksbyEditorial(editorialsearch: String): LiveData<List<Book>>

    @Insert
    suspend fun insert(bookrXeditorial: BookXEditorial)

    @Query("DELETE FROM BookXEditorial")
    fun deleteAll()
}