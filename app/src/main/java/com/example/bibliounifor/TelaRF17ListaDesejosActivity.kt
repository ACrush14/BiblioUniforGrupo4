package com.example.bibliounifor

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bibliounifor.data.AppDatabase
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class TelaRF17ListaDesejosActivity : AppCompatActivity() {

    private val db by lazy { AppDatabase.getDatabase(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf17_lista_desejos)

        setupRecyclerView()
        NavigationUtils.setupBottomNavigation(this)
        NavigationUtils.setupTopBar(this)
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.rvListaDesejos)
        val emptyView = findViewById<TextView>(R.id.txtListaVazia) // Assumindo que existe ou vou adicionar
        recyclerView.layoutManager = LinearLayoutManager(this)
        
        lifecycleScope.launch {
            db.livroDao().buscarTodosLivros().collectLatest { livros ->
                if (livros.isEmpty()) {
                    // Se estiver vazio, popula com alguns livros para teste inicial
                    popularLivrosIniciais()
                } else {
                    val adapter = ListaDesejosAdapter(livros)
                    recyclerView.adapter = adapter
                }
            }
        }
    }

    private suspend fun popularLivrosIniciais() {
        val mockBooks = listOf(
            com.example.bibliounifor.data.EntidadeLivro(
                title = "O Alienista", 
                author = "Machado de Assis", 
                content = "Um clássico da literatura brasileira.", 
                coverResourceId = R.drawable.o_alienista_capa,
                category = "Clássico"
            ),
            com.example.bibliounifor.data.EntidadeLivro(
                title = "Dom Casmurro", 
                author = "Machado de Assis", 
                content = "A dúvida de Bentinho.", 
                coverResourceId = R.drawable.osda,
                category = "Clássico"
            )
        )
        mockBooks.forEach { db.livroDao().inserir(it) }
    }
}
