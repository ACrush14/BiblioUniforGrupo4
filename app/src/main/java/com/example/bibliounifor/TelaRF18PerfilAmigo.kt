package com.example.bibliounifor

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TelaRF18PerfilAmigo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf18_perfil_amigo)

        val txtNomeHeader = findViewById<TextView>(R.id.txtNomeHeader)
        val txtUserHeader = findViewById<TextView>(R.id.txtUserHeader)
        val txtNome = findViewById<TextView>(R.id.txtNomePerfilAmigo)
        val txtUser = findViewById<TextView>(R.id.txtUserPerfilAmigo)
        val txtBio = findViewById<TextView>(R.id.txtBioPerfilAmigo)

        val nome = intent.getStringExtra("AMIGO_NOME") ?: "Usuário Desconhecido"
        val user = intent.getStringExtra("AMIGO_USER") ?: "@usuario"
        val bio = intent.getStringExtra("AMIGO_BIO") ?: "Sem bio disponível."

        txtNomeHeader.text = nome
        txtUserHeader.text = user
        txtNome.text = nome
        txtUser.text = user
        txtBio.text = bio
    }
}
