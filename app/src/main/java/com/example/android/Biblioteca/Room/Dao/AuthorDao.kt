package com.example.android.Biblioteca.Room.Dao


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.android.Biblioteca.Room.Entity.Author
import com.example.android.Biblioteca.Room.Entity.Book
import com.example.android.Biblioteca.Room.Entity.Word


@Dao
interface AuthorDao {

    @Query("SELECT * from Author ORDER BY Author_name ASC")
    fun getAlphaAuthor(): LiveData<List<Author>>

    @Insert
    suspend fun insert(author: Author)

    @Query("DELETE FROM Author")
    fun deleteAll()
}
