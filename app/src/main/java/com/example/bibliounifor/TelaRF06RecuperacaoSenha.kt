package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TelaRF06RecuperacaoSenha : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf06_recuperacao_senha)

        val etEmail = findViewById<EditText>(R.id.editTextEmaiREC)
        val btnEnviar = findViewById<Button>(R.id.buttonEnviarCOD)
        val textErroEmail = findViewById<TextView>(R.id.textErroEmail)

        btnEnviar.setOnClickListener {
            val email = etEmail.text.toString()
            
            // Simulação de validação de e-mail (ex: verificar se não está vazio e se existe no "banco")
            if (email.isNotEmpty() && email.contains("@")) {
                textErroEmail.visibility = View.INVISIBLE
                
                // Navegar para a tela de validação de código
                val intent = Intent(this, TelaRF07ValidacaoDeCodigo::class.java)
                startActivity(intent)
            } else {
                // E-mail inválido ou não cadastrado
                textErroEmail.visibility = View.VISIBLE
            }
        }

    }
}
