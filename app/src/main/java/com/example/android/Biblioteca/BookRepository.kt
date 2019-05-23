package com.example.android.Biblioteca


import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.android.Biblioteca.Room.Dao.AuthorDao
import com.example.android.Biblioteca.Room.Dao.BookDao
import com.example.android.Biblioteca.Room.Dao.TagDao
import com.example.android.Biblioteca.Room.Entity.Book
import com.example.android.Biblioteca.Room.Entity.Word

class BookRepository(private val bookDao: BookDao, private val authorDao: AuthorDao, private val tagDao: TagDao ) {

    val allBooksspan: LiveData<List<Book>> = bookDao.getAlphaBooksSpan()
    val allBooksEng: LiveData<List<Book>> = bookDao.getAlphaBooksEng()


    @WorkerThread
    suspend fun insert(book: Book) {
        bookDao.insert(book)
    }




}
