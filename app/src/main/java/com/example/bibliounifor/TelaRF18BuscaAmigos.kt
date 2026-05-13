package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bibliounifor.data.AppDatabase
import com.google.android.material.button.MaterialButton
import kotlinx.coroutines.launch

class TelaRF18BuscaAmigos : AppCompatActivity() {

    private val db by lazy { AppDatabase.getDatabase(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf18_busca_amigos)

        val queryParam = intent.getStringExtra("SEARCH_QUERY") ?: ""
        val etSearch = findViewById<android.widget.EditText>(R.id.etSearchBuscaAmigo)
        val btnProcurar = findViewById<MaterialButton>(R.id.btnProcurarBuscaAmigo)
        val txtResultados = findViewById<TextView>(R.id.txtResultadosBusca)
        val recyclerView = findViewById<RecyclerView>(R.id.rvBuscaAmigos)
        
        recyclerView.layoutManager = LinearLayoutManager(this)
        etSearch.setText(queryParam)

        fun realizarBusca(q: String) {
            lifecycleScope.launch {
                val usuariosDb = db.usuarioDao().buscarUsuarios(q)
                
                // Converte Usuário do DB para o modelo Amigo do Adapter
                val amigos = usuariosDb.map { 
                    Amigo(it.id, it.nome, it.email, it.usuario, it.bio)
                }

                if (amigos.isEmpty()) {
                    txtResultados.text = "Nenhum usuário encontrado para: \"$q\""
                } else {
                    txtResultados.text = "Resultados para: \"$q\""
                }

                val adapter = AmigoAdapter(amigos, isBusca = true) { amigo ->
                    val intent = Intent(this@TelaRF18BuscaAmigos, TelaRF18PerfilAmigo::class.java)
                    intent.putExtra("AMIGO_ID", amigo.id)
                    intent.putExtra("AMIGO_NOME", amigo.nome)
                    intent.putExtra("AMIGO_USER", amigo.usuario)
                    intent.putExtra("AMIGO_BIO", amigo.bio)
                    startActivity(intent)
                }
                recyclerView.adapter = adapter
            }
        }

        realizarBusca(queryParam)

        btnProcurar.setOnClickListener {
            realizarBusca(etSearch.text.toString())
        }
    }
}
