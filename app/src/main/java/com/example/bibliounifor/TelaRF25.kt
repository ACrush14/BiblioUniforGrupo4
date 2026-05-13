package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TelaRF25 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf25_redefinir_senha_adm)

        val btnSendCode = findViewById<Button>(R.id.btnSendCode)

        btnSendCode.setOnClickListener {
            // Navega para a tela de validação informando que é fluxo ADM
            val intent = Intent(this, TelaRF07ValidacaoDeCodigo::class.java)
            intent.putExtra("isADM", true)
            startActivity(intent)
            finish()
        }
    }
}
