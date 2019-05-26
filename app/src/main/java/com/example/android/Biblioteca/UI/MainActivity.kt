package com.example.android.Biblioteca.UI


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.Biblioteca.Adapter.BookAdapter
import com.example.android.Biblioteca.R
import com.example.android.Biblioteca.Room.Entity.Book
import com.example.android.Biblioteca.ViewModel.BookViewModel


class MainActivity : AppCompatActivity() {


    private lateinit var viewAdapter: BookAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    //private lateinit var libros: MutableList<Book>

    private val newBookActivityRequestCode = 1
    private lateinit var bookViewModel: BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = BookAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        val viewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)
        /*fab.setOnClickListener {
        }*/


        //TODO() TEST
        /* viewModel.getAllAuthor().observe(this, Observer { author ->
             for (author in author) {
                 Log.d("Lista de autores", author.id.toString() + author.name)
             }
         })

         viewModel.getAllEditorial().observe(this, Observer { editorial ->
             for (editorial in editorial) {
                 Log.d("Lista de editorial", editorial.id.toString() + editorial.name)
             }
         })
         viewModel.getAllTag().observe(this, Observer { tag ->
             for (tag in tag) {
                 Log.d("Lista de tag", tag.id.toString() + tag.nameEnglish + tag.nameSpanish)
             }
         })*/
        viewModel.getAllBook().observe(this, Observer { book ->

            book?.let { adapter.setBooks(it) }
            for (book in book) {
                Log.d("Lista de book", book.toString())

                var libros = if (book.isbn > 0) {

                    MutableList(2) { i ->
                        Book(book.isbn,
                                book.titleEnglish,
                                book.titleSpanish,
                                book.caratula,
                                book.edition,
                                book.author,
                                book.tag,
                                book.editorial,
                                book.estado,
                                book.resumeEnglish,
                                book.resumeSpanish


                        )


                    }
                } else {
                    MutableList(2) { i ->
                        Book(0, "N/A", "N/A", "N/A", 0, 0, 0, 0, false, "N/A", "N/A")
                    }
                }
                //initRecycler(libros)
            }


        })





    }
/*
    fun initRecycler(libros: MutableList<Book>) {
        viewManager = LinearLayoutManager(this)
        viewAdapter = BookAdapter(Context)

        rv_book_list.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

    }*/
}




