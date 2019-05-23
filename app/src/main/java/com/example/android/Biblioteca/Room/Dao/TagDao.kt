package com.example.android.Biblioteca.Room.Dao


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.android.Biblioteca.Room.Entity.Tag
import com.example.android.Biblioteca.Room.Entity.Word


@Dao
interface TagDao {

    @Query("SELECT * from Tag ORDER BY tag_name ASC")
    fun getAllTags(): LiveData<List<Tag>>

    @Insert
    suspend fun insert(tag: Tag)

    @Query("DELETE FROM Tag")
    fun deleteAll()
}
