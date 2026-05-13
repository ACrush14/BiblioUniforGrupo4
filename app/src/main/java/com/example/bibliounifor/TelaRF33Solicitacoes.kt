package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TelaRF33Solicitacoes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf33_solicitacoes)

        // 👇 ITENS DE SOLICITAÇÃO
        val item1 = findViewById<LinearLayout>(R.id.itemSolicitacao1)
        val item2 = findViewById<LinearLayout>(R.id.itemSolicitacao2)

        item1.setOnClickListener {
            Toast.makeText(this, "Solicitação 1 selecionada", Toast.LENGTH_SHORT).show()
        }

        item2.setOnClickListener {
            Toast.makeText(this, "Solicitação 2 selecionada", Toast.LENGTH_SHORT).show()
        }

        // 👇 BARRA ADM
        NavigationUtils.setupAdminNavigation(this)
    }
}