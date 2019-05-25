package com.example.android.Biblioteca.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.android.Biblioteca.Room.Dao.AuthorDao
import com.example.android.Biblioteca.Room.Entity.Author

class AuthorRepository ( private val authorDao: AuthorDao ) {

    val allAuthor: LiveData<List<Author>> = authorDao.getAlphaAuthor()


    @WorkerThread
    suspend fun insert( author: Author) {

        authorDao.insert(author)

    }

}