package com.example.android.Biblioteca


import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.android.Biblioteca.Room.Dao.AuthorDao
import com.example.android.Biblioteca.Room.Dao.BookDao
import com.example.android.Biblioteca.Room.Dao.EditorialDao
import com.example.android.Biblioteca.Room.Dao.TagDao
import com.example.android.Biblioteca.Room.Entity.*

class BookRepository(private val bookDao: BookDao, private val authorDao: AuthorDao, private val tagDao: TagDao, private val editorialDao:EditorialDao ) {

    val allBooksspan: LiveData<List<Book>> = bookDao.getAlphaBooksSpan()
    val allBooksEng: LiveData<List<Book>> = bookDao.getAlphaBooksEng()
    val allFavo: LiveData<List<Book>> = bookDao.getFavorites(true)
    val allAuthor:LiveData<List<Author>> = authorDao.getAlphaAuthor()
    val allTags:LiveData<List<Tag>> = tagDao.getAllTags()
    val allEditorial:LiveData<List<Editorial>> = editorialDao.getAllEditorial()



    @WorkerThread
    suspend fun insert(book: Book,author:Author,tag:Tag , editorial:Editorial) {
        bookDao.insert(book)
        authorDao.insert(author)
        tagDao.insert(tag)
        editorialDao.insert(editorial)
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
    fun getBooksByTagEng(tag: String): LiveData<List<Book>>{
        return bookDao.getByTagEng(tag)
    }

    @WorkerThread
    fun getBooksByTagSpan(tag: String): LiveData<List<Book>>{
        return bookDao.getByTagSpan(tag)
    }

    @WorkerThread
    fun getBooksByTitleEsp(title: String): LiveData<List<Book>>{
        return bookDao.getByTitleEsp(title)
    }

    @WorkerThread
    fun getBooksByTitleEng(title: String): LiveData<List<Book>>{
        return bookDao.getByTitleEng(title)
    }

    @WorkerThread
    fun getBooksByEditorial(title: String): LiveData<List<Book>>{
        return bookDao.getByEditorial(title)
    }





}
