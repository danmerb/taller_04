package com.example.android.Biblioteca.Room.Dao


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.android.Biblioteca.Room.Entity.Book
import com.example.android.Biblioteca.Room.Entity.Word


@Dao
interface BookDao {

    //mostrar libros titulo espanol ordenados alfabeticamente
    @Query("SELECT * from Book ORDER BY book_titleSpanish ASC")
    fun getAlphaBooksSpan(): LiveData<List<Book>>

    //mostrar libros titulo ingles ordenados alfabeticamente
    @Query("SELECT * from Book ORDER BY book_titleEnglish ASC")
    fun getAlphaBooksEng(): LiveData<List<Book>>

    //buscar por autor
    @Query("SELECT * FROM Book INNER JOIN Author ON author.id_author== Book.id_author WHERE Author.Author_name== :AuthorSearch ")
    fun getByAuthor(AuthorSearch: String): LiveData<List<Book>>

    //buscar por tag
    @Query("SELECT * FROM Book INNER JOIN Tag ON Tag.id_tag== Book.id_tags WHERE Tag.tag_name== :TagSearch ")
    fun getByTag(TagSearch: String): LiveData<List<Book>>

    //buscar por titulo en espanol
    @Query("SELECT * FROM Book  WHERE Book.book_titleSpanish= :TitleSearch ")
    fun getByTitleEsp(TitleSearch: String): LiveData<List<Book>>

    //buscar por titulo ingles
    @Query("SELECT * FROM Book  WHERE Book.book_titleEnglish= :TitleSearch ")
    fun getByTitleEng(TitleSearch: String): LiveData<List<Book>>

    //buscar por Editorial
    @Query("SELECT * FROM Book INNER JOIN Editorial ON editorial.id_editorial== Book.id_editorial WHERE Editorial.Editorial_name== :EditorialSearch ")
    fun getByEditorial(EditorialSearch: String): LiveData<List<Book>>

    //mostrar los favoritos
    @Query("SELECT * FROM Book  WHERE Book.book_estado= :Estado")
    fun getFavorites(Estado: Boolean): LiveData<List<Book>>

    //update favoritos
    @Query("UPDATE  Book SET book_estado = :estado WHERE Book.book_isbn= :isbn")
    fun UpdateFavorites(isbn: Int,estado:Boolean)


    @Insert
    suspend fun insert(book:Book)

    @Query("DELETE FROM Book")
    fun deleteAll()
}
