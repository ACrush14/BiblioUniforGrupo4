package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TelaRF24 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf24_login_adm)

        val etEmail = findViewById<EditText>(R.id.editEmailAdm)
        val etPassword = findViewById<EditText>(R.id.editSenhaAdm)
        val etCredential = findViewById<EditText>(R.id.editCredencialAdm)
        val tvErrorMessage = findViewById<TextView>(R.id.textErroAdm)
        val btnLogin = findViewById<Button>(R.id.buttonEntrarAdm)
        val btnForgotPassword = findViewById<TextView>(R.id.textEsqueceuSenhaAdm)
        val btnCreateAccount = findViewById<TextView>(R.id.textCriarContaAdm)
        val iconOlho = findViewById<ImageView>(R.id.iconOlhoSenhaAdm)

        // MOSTRAR/OCULTAR SENHA
        var senhaVisivel = false
        iconOlho.setOnClickListener {
            senhaVisivel = !senhaVisivel
            if (senhaVisivel) {
                etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            } else {
                etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
            etPassword.setSelection(etPassword.text.length)
        }

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val credential = etCredential.text.toString().trim()

            if (email.isEmpty() || password.isEmpty() || credential.isEmpty()) {
                tvErrorMessage.text = "Preencha todos os campos"
                tvErrorMessage.visibility = View.VISIBLE
            } else if (email == "a" && password == "b" && credential == "c") {
                val intent = Intent(this, TelaRF30DashboardADM::class.java)
                startActivity(intent)
                finish()
            } else {
                tvErrorMessage.text = "Email ou senha incorreto"
                tvErrorMessage.visibility = View.VISIBLE
            }
        }

        btnForgotPassword.setOnClickListener {
            val intent = Intent(this, TelaRF25::class.java)
            startActivity(intent)
        }

        btnCreateAccount.setOnClickListener {
            val intent = Intent(this, TelaRF28NovaContaADM::class.java)
            startActivity(intent)
        }
    }
}
