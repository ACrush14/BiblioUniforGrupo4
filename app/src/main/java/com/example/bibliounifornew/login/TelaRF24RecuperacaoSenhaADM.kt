package com.example.bibliounifornew.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.example.bibliounifornew.R
import com.example.bibliounifornew.usuario.TelaRF08DashboardUsuario

class TelaRF24RecuperacaoSenhaADM : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf24_recuperacao_senha_adm)

        // CAMPOS
        val email = findViewById<EditText>(R.id.editEmailRecuperar)

        // TEXTOS
        val erro = findViewById<TextView>(R.id.textErroEmailRecuperar)
        val voltarLogin = findViewById<TextView>(R.id.textVoltarLogin)

        // BOTÃO
        val botaoEnviar = findViewById<MaterialButton>(R.id.buttonEnviarCodigo)

        // EMAIL VÁLIDO
        val emailValido = "emailvalido@gmail.com"

        // BOTÃO ENVIAR
        botaoEnviar.setOnClickListener {

            val textoEmail = email.text.toString().trim()

            erro.visibility = View.GONE

            when {

                textoEmail.isEmpty() -> {
                    erro.text = "Digite um e-mail"
                    erro.visibility = View.VISIBLE
                }

                textoEmail != emailValido -> {
                    erro.text = "E-mail não cadastrado"
                    erro.visibility = View.VISIBLE
                }

                else -> {
                    //vai pra tela de digitar o codigo
                }
            }
        }

        // VOLTAR LOGIN
        voltarLogin.setOnClickListener {
            finish()
        }

        // UX MELHORADA
        email.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                erro.visibility = View.GONE
            }
        }
    }
}