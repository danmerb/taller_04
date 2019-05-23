package com.example.android.Biblioteca.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.android.Biblioteca.BookRepository
import com.example.android.Biblioteca.Room.BookRoomDatabase
import com.example.android.Biblioteca.Room.Entity.Book

class BookViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: BookRepository
    val allBooksEng: LiveData<List<Book>>

    init {
        val BookDao = BookRoomDatabase.getDatabase(application,viewModelScope).bookDao()
        val AuthorDao = BookRoomDatabase.getDatabase(application,viewModelScope).AuthorDao()
        val TagDao = BookRoomDatabase.getDatabase(application,viewModelScope).TagDao()
        val EditorialDao = BookRoomDatabase.getDatabase(application,viewModelScope).EditorialDao()
        repository = BookRepository(BookDao,AuthorDao,TagDao,EditorialDao)
        allBooksEng = repository.allBooksEng
    }


}