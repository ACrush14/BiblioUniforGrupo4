package com.example.bibliounifornew.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bibliounifornew.R

class TelaRF05RecuperacaoSenha : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf05_recuperacao_senha)

        val etEmail = findViewById<EditText>(R.id.editTextEmailRec)
        val btnEnviar = findViewById<Button>(R.id.buttonEnviarCOD)
        val btnVoltar = findViewById<Button>(R.id.buttonVoltarLog)
        val textErroEmail = findViewById<TextView>(R.id.textErroEmail)

        btnEnviar.setOnClickListener {
            val email = etEmail.text.toString()

            // Simulação de validação de e-mail (ex: verificar se não está vazio e se existe no "banco")
            if (email.isNotEmpty() && email.contains("@")) {
                textErroEmail.visibility = View.INVISIBLE

                // Navegar para a tela de validação de código
                val intent = Intent(this, TelaRF06ValidacaoDeCodigo::class.java)
                startActivity(intent)
            } else {
                // E-mail inválido ou não cadastrado
                textErroEmail.visibility = View.VISIBLE
            }
        }

        btnVoltar.setOnClickListener {
            val intent = Intent(this, TelaRF03LoginAluno::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
    }
}