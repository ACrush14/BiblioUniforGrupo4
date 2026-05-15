package com.example.bibliounifornew.adm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bibliounifornew.NavigationUtils
import com.example.bibliounifornew.R
import com.example.bibliounifornew.adm.TelaRF33CadastroDeLivros
import com.google.android.material.button.MaterialButton

class TelaRF28CrudADM : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf28_crud_adm)

        // Configuração da Navegação ADM (Barra inferior e topo)
        NavigationUtils.setupAdminNavigation(this)

        val btnCriarMidia = findViewById<MaterialButton>(R.id.buttonCriarMidia)
        val btnVerificarMidia = findViewById<MaterialButton>(R.id.buttonVerificarMidia)
        val btnGerenciarUsuario = findViewById<MaterialButton>(R.id.buttonGerenciarUsuarios)

        btnCriarMidia.setOnClickListener {
            val intent = Intent(this, TelaRF33CadastroDeLivros::class.java)
            startActivity(intent)
        }

        btnVerificarMidia.setOnClickListener {
            val intent = Intent(this, TelaRF42VerificarMidia::class.java)
            startActivity(intent)
        }

        btnGerenciarUsuario.setOnClickListener {
            val intent = Intent(this, TelaRF29GerenciamentoDeUsuarios::class.java)
            startActivity(intent)
        }

    }

}