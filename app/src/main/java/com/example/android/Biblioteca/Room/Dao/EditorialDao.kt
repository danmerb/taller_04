package com.example.android.Biblioteca.Room.Dao

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query
import com.example.android.Biblioteca.Room.Entity.Editorial


interface EditorialDao {

    @Query("SELECT * from Editorial ORDER BY id_editorial ASC")
    fun getAllEditorial(): LiveData<List<Editorial>>

    @Insert
    suspend fun insert(editorial: Editorial)

    @Query("DELETE FROM Editorial")
    fun deleteAll()
}