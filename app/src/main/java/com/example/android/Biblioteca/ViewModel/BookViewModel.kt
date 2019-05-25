package com.example.android.Biblioteca.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.android.Biblioteca.BookRepository
import com.example.android.Biblioteca.Room.BookRoomDatabase
import com.example.android.Biblioteca.Room.Entity.Author
import com.example.android.Biblioteca.Room.Entity.Book
import com.example.android.Biblioteca.Room.Entity.Editorial
import com.example.android.Biblioteca.Room.Entity.Tag
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: BookRepository
   // val allBooksEng: LiveData<List<Book>>

    init {
        val BookDao = BookRoomDatabase.getDatabase(application,viewModelScope).bookDao()
        val AuthorDao = BookRoomDatabase.getDatabase(application,viewModelScope).AuthorDao()
        val TagDao = BookRoomDatabase.getDatabase(application,viewModelScope).TagDao()
        val EditorialDao = BookRoomDatabase.getDatabase(application,viewModelScope).EditorialDao()
        repository = BookRepository(BookDao,AuthorDao,TagDao,EditorialDao)
       // allBooksEng = repository.allBooksEng
    }

    fun insertBook(book: Book) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertBook(book)
    }

    fun insertAuthor(author:Author)= viewModelScope.launch(Dispatchers.IO) {
        repository.insertAuthor(author)
    }

    fun insertTag(tag: Tag)= viewModelScope.launch(Dispatchers.IO) {
        repository.insertTag(tag)
    }


    fun insertEditorial(editorial: Editorial)= viewModelScope.launch(Dispatchers.IO) {
        repository.insertEditorial(editorial)
    }


    fun getAll():LiveData<List<Book>> = repository.getAll()

    fun getAllTag():LiveData<List<Tag>> = repository.getAllTag()
    fun getAllEditorial():LiveData<List<Editorial>> = repository.getAllEditorial()
    fun getAllAuthor():LiveData<List<Author>> = repository.getAllAuthor()

}