package com.example.android.Biblioteca


import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.android.Biblioteca.Room.Dao.AuthorDao
import com.example.android.Biblioteca.Room.Dao.BookDao
import com.example.android.Biblioteca.Room.Dao.TagDao
import com.example.android.Biblioteca.Room.Entity.Author
import com.example.android.Biblioteca.Room.Entity.Book
import com.example.android.Biblioteca.Room.Entity.Tag
import com.example.android.Biblioteca.Room.Entity.Word

class BookRepository(private val bookDao: BookDao, private val authorDao: AuthorDao, private val tagDao: TagDao ) {

    val allBooksspan: LiveData<List<Book>> = bookDao.getAlphaBooksSpan()
    val allBooksEng: LiveData<List<Book>> = bookDao.getAlphaBooksEng()
    val allFavo: LiveData<List<Book>> = bookDao.getFavorites(true)
    val allAuthor:LiveData<List<Author>> = authorDao.getAlphaAuthor()
    val allTags:LiveData<List<Tag>> = tagDao.getAllTags()



    @WorkerThread
    suspend fun insert(book: Book,author:Author,tag:Tag) {
        bookDao.insert(book)
        authorDao.insert(author)
        tagDao.insert(tag)
    }

    @WorkerThread
    fun marcarODesmarcarFav(book: Book) {
        var flag= !book.estado
        bookDao.UpdateFavorites(book.isbn, flag)
    }

    @WorkerThread
    fun getBooksByAuthor(author: String): LiveData<List<Book>>{
        return bookDao.getByAuthor(author)
    }

    @WorkerThread
    fun getBooksByTag(tag: String): LiveData<List<Book>>{
        return bookDao.getByTag(tag)
    }





}
