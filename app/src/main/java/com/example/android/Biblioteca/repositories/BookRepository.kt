package com.example.android.Biblioteca.repositories


import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.android.Biblioteca.Room.Dao.*
import com.example.android.Biblioteca.Room.Entity.*

class BookRepository(private val bookDao: BookDao, private val book_authorDao: BookXAuthorDao, private val book_tagDao: BookXTagDao, private val book_editorialDao:BookXEditorialDao ) {

    val allBooksspan: LiveData<List<Book>> = bookDao.getAlphaBooksSpan()
    val allBooksEng: LiveData<List<Book>> = bookDao.getAlphaBooksEng()
    val allFavo: LiveData<List<Book>> = bookDao.getFavorites(true)
   // val allAuthor:LiveData<List<Author>> = authorDao.getAlphaAuthor()
   // val allTags:LiveData<List<Tag>> = tagDao.getAllTags()
   // val allEditorial:LiveData<List<Editorial>> = editorialDao.getAllEditorial()



    @WorkerThread
    suspend fun insert(book: Book,bxauthor:BookXAuthor,bxtag:BookXTag , bxEditorial:BookXEditorial) {
        bookDao.insert(book)
        book_authorDao.insert(bxauthor)
        book_tagDao.insert(bxtag)
        book_editorialDao.insert(bxEditorial)
    }

    fun getAll():LiveData<List<Book>> = bookDao.getAll()

    @WorkerThread
    fun marcarODesmarcarFav(book: Book) {
        var flag= !book.estado
        bookDao.UpdateFavorites(book.isbn, flag)
    }

    @WorkerThread
    fun getBooksByTagEng(tag: String): LiveData<List<Book>>{
        return book_tagDao.getBooksbyTagEng(tag)
    }

    @WorkerThread
    fun getBooksbyTagSpa(tag: String): LiveData<List<Book>>{
        return book_tagDao.getBooksbyTagSpa(tag)
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
    fun getBooksByEditorial(editorial: String): LiveData<List<Book>>{
        return book_editorialDao.getBooksbyEditorial(editorial)
    }

    @WorkerThread
    fun getBooksByAuthor(author: String): LiveData<List<Book>>{
        return book_authorDao.getBooksbyAuthor(author)
    }





}
