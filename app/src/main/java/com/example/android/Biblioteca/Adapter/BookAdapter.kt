package com.example.android.Biblioteca.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.Biblioteca.R
import com.example.android.Biblioteca.Room.Entity.Book
import com.example.android.Biblioteca.Room.Entity.Word
//import com.example.android.Biblioteca.models.Book
import kotlinx.android.synthetic.main.list_element_book.view.*
import java.util.zip.Inflater

class BookAdapter internal constructor(context: Context) :  RecyclerView.Adapter<BookAdapter.BookViewHolder>
() {

    private var books = emptyList<Book>() // Cached copy of words

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookAdapter.BookViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_element_book, parent, false)
        return BookViewHolder(itemView)
    }

    override fun getItemCount()=books.size

    override fun onBindViewHolder(holder: BookAdapter.BookViewHolder, position: Int) {
        holder.bind(books[position])
    }
    internal fun setBooks(words: List<Book>) {
        this.books = words
        notifyDataSetChanged()
    }

    class BookViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bind(book: Book){
            with(itemView){
               // titulo.text = book.titulo
                /*tvEdicion =  findViewById(R.id.edicion)
                tvEdicion.text = libro.edicion.toString()
                tvEditorial =  findViewById(R.id.editorial)
                tvEditorial.text = libro.editorial
                tvISBN =  findViewById(R.id.isbn)
                tvISBN.text = libro.isbn.toString()*/
                //resumen.text = book.resumen
            }
        }
    }







   /* override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_element_book, parent, false)


        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: BookAdapter.ViewHolder, position: Int) = holder.bind(items[position])

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        lateinit var tvTitulo: TextView
        lateinit var tvEdicion: TextView
        lateinit var tvEditorial: TextView
        lateinit var tvISBN: TextView
        lateinit var tvResumen: TextView

        fun bind(libro: Book) = with(itemView){
            Log.d("CUSTOM",libro.titulo)
            tvTitulo =  findViewById(R.id.titulo)
            tvTitulo.text = libro.titulo
            /*tvEdicion =  findViewById(R.id.edicion)
            tvEdicion.text = libro.edicion.toString()
            tvEditorial =  findViewById(R.id.editorial)
            tvEditorial.text = libro.editorial
            tvISBN =  findViewById(R.id.isbn)
            tvISBN.text = libro.isbn.toString()*/
            tvResumen =  findViewById(R.id.resumen)
            tvResumen.text = libro.resumen

            this.setOnClickListener {
                var mIntent = Intent(it.context,  SecondActivity:: class.java)
                mIntent.putExtra("key_resumen", libro.resumen)
                mIntent.putExtra("key_titulo", libro.titulo)
                this.context.startActivity(mIntent)
            }
        }
    }*/

}