package com.example.android.Biblioteca



import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.Biblioteca.Adapter.BookAdapter
import com.example.android.Biblioteca.Room.Entity.Author
import com.example.android.Biblioteca.Room.Entity.Book
import com.example.android.Biblioteca.Room.Entity.Editorial
import com.example.android.Biblioteca.Room.Entity.Tag
import com.example.android.Biblioteca.ViewModel.BookViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var libros: MutableList<Book>

    private val newBookActivityRequestCode = 1
    private lateinit var bookViewModel: BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView = findViewById<RecyclerView>(R.id.rv_book_list)
        val adapter = BookAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

       fillDB()
        val viewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)
        fab.setOnClickListener {
           // viewModel.insertBook(Book(1451648537, "Steve Jobs", "Steve Jobs", "img1", 1, 1, 1, 2, false, "sdd", "ffdf"),
             //       Author(1, "Nexxtor"), Tag(1, "romance", "love"),
               //     Editorial(2, "qwe"))
        }



        //TODO() TEST
        viewModel.getAllAuthor().observe(this, Observer { author ->
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
        })





    }

    fun fillDB() {
        val viewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)
        //Insertando Autores
        viewModel.insertAuthor(Author(1,"Walter Isaacson "))
        viewModel.insertAuthor( Author(2,"Neil Druckmann"))

        //Insertando Editorial
        viewModel.insertEditorial(Editorial(1,"Simon & Schuster"))
        viewModel.insertEditorial(Editorial(2,"Dark Horse"))

        //Insertando Tag
        viewModel.insertTag(Tag(1,"Historia","Story"))
        viewModel.insertTag(Tag(2,"Aventura","Adventure"))



       /* viewModel.insertBook(Book(1451648537, "Steve Jobs", "Steve Jobs", "steve_jobs.jpg", 1,
                1, 1, 2, false, "f", "r"),
                Author(1, "Nexxtor"), Tag(1, "romance", "love"),
                Editorial(2, "qwe"))*/

    }















        //initRecycler()

/**
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = WordListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Get a new or existing ViewModel from the ViewModelProvider.
        wordViewModel = ViewModelProviders.of(this).get(WordViewModel::class.java)

        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        wordViewModel.allWords.observe(this, Observer { words ->
            // Update the cached copy of the words in the adapter.
            words?.let { adapter.setWords(it) }
        })

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, NewBookActivity::class.java)
            startActivityForResult(intent, newWordActivityRequestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == newWordActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.let { data ->
                val word = Word(data.getStringExtra(NewBookActivity.EXTRA_REPLY))
                wordViewModel.insert(word)
            }
        } else {
            Toast.makeText(
                    applicationContext,
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG
            ).show()

 */


    /*fun initRecycler() {
        viewManager = LinearLayoutManager(this)
        viewAdapter = BookAdapter(libros)

        rv_book_list.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

    }*/






}
