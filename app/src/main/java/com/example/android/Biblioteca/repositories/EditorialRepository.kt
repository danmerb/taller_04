package com.example.android.Biblioteca.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.android.Biblioteca.Room.Dao.EditorialDao
import com.example.android.Biblioteca.Room.Entity.Editorial

class EditorialRepository ( private val editorialDao: EditorialDao ) {

    val allEditorials: LiveData<List<Editorial>> =editorialDao.getAllEditorial()


    @WorkerThread
    suspend fun insert( editorial: Editorial) {

        editorialDao.insert(editorial)

    }

}