package com.example.android.Biblioteca.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.android.Biblioteca.repositories.BookRepository
import com.example.android.Biblioteca.Room.BookRoomDatabase
import com.example.android.Biblioteca.Room.Entity.Author
import com.example.android.Biblioteca.Room.Entity.Book
import com.example.android.Biblioteca.Room.Entity.Editorial
import com.example.android.Biblioteca.Room.Entity.Tag
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: BookRepository
    val allBooksEng: LiveData<List<Book>>

    init {
        val BookDao = BookRoomDatabase.getDatabase(application,viewModelScope).bookDao()
        val AuthorDao = BookRoomDatabase.getDatabase(application,viewModelScope).AuthorDao()
        val TagDao = BookRoomDatabase.getDatabase(application,viewModelScope).TagDao()
        val EditorialDao = BookRoomDatabase.getDatabase(application,viewModelScope).EditorialDao()
        repository = BookRepository(BookDao, AuthorDao, TagDao, EditorialDao)
        allBooksEng = repository.allBooksEng
    }

    fun insertBook(book: Book, author:Author, tag: Tag, editorial: Editorial) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(book,author,tag,editorial)
    }

    fun getAll():LiveData<List<Book>> = repository.getAll()

}