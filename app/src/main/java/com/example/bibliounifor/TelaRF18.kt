package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TelaRF18 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf18_amigos)

        setupRecyclerView()
        setupButtons()
        NavigationUtils.setupBottomNavigation(this)
        NavigationUtils.setupTopBar(this)
    }

    private fun setupButtons() {
        val btnAdicionarAmigo = findViewById<com.google.android.material.button.MaterialButton>(R.id.btnAdicionarAmigo)
        btnAdicionarAmigo.setOnClickListener {
            // ISSUE 1 — BOTÃO + (Abre Adicionar Amigo)
            startActivity(Intent(this, TelaRF18_2AdicionarAmigo::class.java))
        }
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.rvAmigos)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val mockFriends = listOf(
            Amigo(1, "Ronaldo Alves", usuario = "@ronaldo_alves", bio = "Gosto de ler suspenses."),
            Amigo(2, "Robson Gonçalves", usuario = "@robson_g", bio = "Estudante de Engenharia."),
            Amigo(3, "Vitória Ferreira", usuario = "@vitoria_f", bio = "Amante de poesia."),
            Amigo(4, "Marta Viana", usuario = "@marta_v", bio = "Bibliotecária por paixão."),
            Amigo(5, "Adriano de Souza", usuario = "@adriano_s", bio = "Leitor voraz de ficção científica.")
        )

        val adapter = AmigoAdapter(mockFriends) { amigo ->
            // Abre perfil ao clicar
            val intent = Intent(this, TelaRF18PerfilAmigo::class.java)
            intent.putExtra("AMIGO_ID", amigo.id)
            intent.putExtra("AMIGO_NOME", amigo.nome)
            intent.putExtra("AMIGO_USER", amigo.usuario)
            intent.putExtra("AMIGO_BIO", amigo.bio)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }
}
