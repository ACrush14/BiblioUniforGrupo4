package com.example.bibliounifor

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class GoogleLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_login)

        val edtEmailGoogle = findViewById<EditText>(R.id.edtEmailGoogle)
        val btnProxima = findViewById<Button>(R.id.btnProxima)

        btnProxima.setOnClickListener {
            val email = edtEmailGoogle.text.toString()

            if (email.isEmpty()) {
                Toast.makeText(this, "Digite seu e-mail do Google", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Conectado com a conta: $email", Toast.LENGTH_LONG).show()
            }
        }
    }
}