package com.example.bibliounifor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TelaRF19 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf19_status_aluguel)

        setupRecyclerView()
        NavigationUtils.setupBottomNavigation(this)
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.rvLivrosAlugados)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Mock data
        val mockBooks = listOf(
            com.example.bibliounifor.data.EntidadeLivro(1, "O Senhor dos Anéis", "J.R.R. Tolkien", content = "Resumo do livro...", coverResourceId = R.drawable.osda)
        )

        val adapter = LivroAdapter(mockBooks) { livro ->
            // Ir para detalhes ou renovação
        }
        recyclerView.adapter = adapter
    }
}
