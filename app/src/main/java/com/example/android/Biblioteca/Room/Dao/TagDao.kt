package com.example.android.Biblioteca.Room.Dao


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.android.Biblioteca.Room.Entity.Word


@Dao
interface TagDao {

    @Query("SELECT * from word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): LiveData<List<Word>>

    @Insert
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    fun deleteAll()
}
