package com.example.android.Biblioteca.Room

import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import com.example.android.Biblioteca.Room.Dao.BookDao
import com.example.android.Biblioteca.Room.Dao.WordDao
import com.example.android.Biblioteca.Room.Entity.Book
import com.example.android.Biblioteca.Room.Entity.Word
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * This is the backend. The database. This used to be done by the OpenHelper.
 * The fact that this has very few comments emphasizes its coolness.
 */
@Database(entities = [Book::class], version = 1)
abstract class BookRoomDatabase : RoomDatabase() {

    abstract fun bookDao(): BookDao

    companion object {
        @Volatile
        private var INSTANCE: BookRoomDatabase? = null

        fun getDatabase(
                context: Context,
                scope: CoroutineScope
        ): BookRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        BookRoomDatabase::class.java,
                        "book_database"
                )
                        .fallbackToDestructiveMigration()
                        .addCallback(Companion.BookDatabaseCallback(scope))
                        .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

        private class BookDatabaseCallback(
                private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            /**
             * Override the onOpen method to populate the database.
             * For this sample, we clear the database every time it is created or opened.
             */
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                // If you want to keep the data through app restarts,
                // comment out the following line.
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.bookDao())
                    }
                }
            }
        }

        /**
         * Populate the database in a new coroutine.
         * If you want to start with more words, just add them.
         */
        suspend fun populateDatabase(bookDao: BookDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            bookDao.deleteAll()

            //var book = Word("Hello")
           // wordDao.insert(word)
            //word = Word("World!")
            //wordDao.insert(word)
        }
    }

}
