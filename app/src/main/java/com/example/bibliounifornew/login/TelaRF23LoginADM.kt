package com.example.bibliounifornew.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bibliounifornew.R
import com.example.bibliounifornew.adm.TelaRF28DashboardADM

class TelaRF23LoginADM : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf23_login_adm)

        // CAMPOS
        val email = findViewById<EditText>(R.id.editEmailAdm)
        val senha = findViewById<EditText>(R.id.editSenhaAdm)
        val credential = findViewById<EditText>(R.id.editCredencialAdm)


        // BOTÃO
        val botaoEntrar = findViewById<Button>(R.id.buttonEntrarAdm)

        // TEXTOS
        val erro = findViewById<TextView>(R.id.textErroAdm)
        val criarConta = findViewById<TextView>(R.id.textCriarContaAdm)
        val esqueceuSenha = findViewById<TextView>(R.id.textEsqueceuSenhaAdm)

        // LOGIN
        botaoEntrar.setOnClickListener {

            val textoEmail = email.text.toString().trim()
            val textoSenha = senha.text.toString().trim()
            val textoCredencial = credential.text.toString().trim()

            erro.visibility = View.GONE

            when {

                textoEmail.isEmpty() || textoSenha.isEmpty() || textoCredencial.isEmpty() -> {
                    erro.text = "Preencha todos os campos"
                    erro.visibility = View.VISIBLE
                }

                textoEmail != "a" ||
                        textoSenha != "b" ||
                        textoCredencial != "c" -> {

                    erro.text = "E-mail, senha ou credencial incorretos"
                    erro.visibility = View.VISIBLE
                }

                else -> {
                    Toast.makeText(
                        this,
                        "Login realizado com sucesso!",
                        Toast.LENGTH_SHORT
                    ).show()

                    val intent = Intent(this, TelaRF28DashboardADM::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }

        // CRIAR CONTA -> TelaRF05
        criarConta.setOnClickListener {
            val intent = Intent(this, TelaRF04CadastroNovoUsuario::class.java)
            startActivity(intent)
        }

        // ESQUECEU SENHA -> TelaRF06
        esqueceuSenha.setOnClickListener {
            val intent = Intent(this, TelaRF05RecuperacaoSenha::class.java)
            startActivity(intent)
        }


        // UX MELHORADA (remove erro ao focar)
        email.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) erro.visibility = View.GONE
        }

        senha.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) erro.visibility = View.GONE
        }
    }
}