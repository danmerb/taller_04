package com.example.android.Biblioteca.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.android.Biblioteca.Room.Dao.TagDao
import com.example.android.Biblioteca.Room.Entity.Tag

class TagRepository ( private val tagDao: TagDao ) {

    val alltags: LiveData<List<Tag>> = tagDao.getAllTags()


    @WorkerThread
    suspend fun insert( tag: Tag) {

        tagDao.insert(tag)

    }

}