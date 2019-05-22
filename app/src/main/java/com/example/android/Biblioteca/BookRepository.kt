package com.example.android.Biblioteca


import androidx.lifecycle.LiveData
import androidx.annotation.WorkerThread
import com.example.android.Biblioteca.Room.Dao.BookDAO
import com.example.android.Biblioteca.Room.Dao.WordDao
import com.example.android.Biblioteca.Room.Entity.Word

class BookRepository(private val bookDao: BookDAO,private val authorDao: BookDAO) {

    //val allWords: LiveData<List<Word>> = bookDao.getAllWords()

    @WorkerThread
    suspend fun insert(word: Word) {
        //wordDao.insert(word)
    }


}
