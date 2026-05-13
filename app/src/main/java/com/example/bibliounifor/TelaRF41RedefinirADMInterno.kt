package com.example.bibliounifor

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.widget.ImageView

class TelaRF41RedefinirADMInterno : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf41_redefinir_adm_interno)

        val etSenha = findViewById<EditText>(R.id.editTextTextPassword)
        val etSenhaConfirmacao = findViewById<EditText>(R.id.editTextTextPasswordConfirmacao)
        val bntSalvar = findViewById<Button>(R.id.buttonSalvar)

        // 👇 BARRA ADM
        NavigationUtils.setupAdminNavigation(this)

        bntSalvar.setOnClickListener {
            val s1 = etSenha.text.toString()
            val s2 = etSenhaConfirmacao.text.toString()

            if (s1 == s2 && s1.isNotEmpty()) {
                Toast.makeText(this, "Senha redefinida com sucesso!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "As senhas não coincidem", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
