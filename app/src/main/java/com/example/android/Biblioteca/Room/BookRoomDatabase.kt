package com.example.android.Biblioteca.Room

import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import com.example.android.Biblioteca.Room.Dao.*
import com.example.android.Biblioteca.Room.Entity.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * This is the backend. The database. This used to be done by the OpenHelper.
 * The fact that this has very few comments emphasizes its coolness.
 */
@Database(entities = [Book::class,Author::class,Editorial::class,Tag::class], version = 1)
abstract class BookRoomDatabase : RoomDatabase() {

    abstract fun bookDao(): BookDao
    abstract fun AuthorDao(): AuthorDao
    abstract fun TagDao(): TagDao
    abstract fun EditorialDao(): EditorialDao

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
                        populateDatabase(database.bookDao(),database.AuthorDao(),database.TagDao(),database.EditorialDao())
                    }
                }
            }
        }

        /**
         * Populate the database in a new coroutine.
         * If you want to start with more words, just add them.
         */
        suspend fun populateDatabase(bookDao: BookDao,authorDao: AuthorDao,tagDao: TagDao,editorialDao: EditorialDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            bookDao.deleteAll()
            authorDao.deleteAll()
            tagDao.deleteAll()
            editorialDao.deleteAll()


            //Insertando Autores
            authorDao.insert(Author(1,"Walter Isaacson "))
            authorDao.insert( Author(2,"Neil Druckmann"))

            //Insertando Editorial
            editorialDao.insert(Editorial(1,"Simon & Schuster"))
            editorialDao.insert(Editorial(2,"Dark Horse"))

            //Insertando Tag
            tagDao.insert(Tag(1,"Historia","Story"))
            tagDao.insert(Tag(2,"Aventura","Adventure"))

            //Insertando book
            bookDao.insert(Book(1451648537, "Steve Jobs", "Steve Jobs", "steve_jobs.jpg", 1,
                    1, 1, 1, false, "Based on more than forty interviews with Jobs conducted over two years—as well as interviews with more than a hundred family members, friends, adversaries, competitors, and colleagues—Walter Isaacson has written a riveting story of the roller-coaster life and searingly intense personality of a creative entrepreneur whose passion for perfection and ferocious drive revolutionized six industries: personal computers, animated movies, music, phones, tablet computing, and digital publishing.",
                    "Basado en más de cuarenta entrevistas con Jobs realizadas durante dos años, así como entrevistas con más de cien familiares, amigos, adversarios, competidores y colegas, Walter Isaacson ha escrito una historia fascinante sobre la vida de la montaña rusa y su intensa intensidad. personalidad de un empresario creativo cuya pasión por la perfección y el impulso feroz revolucionaron seis industrias: computadoras personales, películas animadas, música, teléfonos, computación para tabletas y publicación digital."))
            bookDao.insert(Book(1616552123,"The Last of Us","El ultimo de nosotros","the_last_of_us.jpg",
                    1,2,2,2,false,"Naughty Dog creative director Neil Druckmann and rising comics star Faith Erin Hicks team up for the comics-exclusive first chapter of the wildly anticipated new game, The Last of Us! Nineteen years ago, a parasitic fungal outbreak killed the majority of the world's population, forcing survivors into a handful of quarantine zones.",
                    "El director creativo de Naughty Dog, Neil Druckmann, y la estrella emergente de cómics, Faith Erin Hicks, se unen para el primer capítulo exclusivo de cómics del inesperado nuevo juego, ¡El último de nosotros! Hace diecinueve años, un brote de hongos parásitos mató a la mayoría de la población mundial, obligando a los sobrevivientes a un puñado de zonas de cuarentena."))


            //var book = Word("Hello")
           // wordDao.insert(word)
            //word = Word("World!")
            //wordDao.insert(word)
        }
    }

}
