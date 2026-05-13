package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class TelaRF08RedefinirSenha : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf08_redefinicao_de_senha)

        val editSenha1 = findViewById<EditText>(R.id.editSenha1)
        val editSenha2 = findViewById<EditText>(R.id.editSenha2)
        val btnRedefinir = findViewById<Button>(R.id.btnRedefinirSenha1)
        
        val textErroDiferente = findViewById<TextView>(R.id.textErroDiferente)
        val textErroRequisitos = findViewById<TextView>(R.id.textRequisitosSenha)

        // Inicializa erros como invisíveis ou cor padrão
        textErroDiferente.visibility = View.GONE

        btnRedefinir.setOnClickListener {
            val senha1 = editSenha1.text.toString()
            val senha2 = editSenha2.text.toString()

            val senhaValida = validarSenha(senha1)
            val senhasIguais = senha1 == senha2

            if (senhaValida && senhasIguais) {
                // Ao invés de ir direto para o login, mostra o popup de sucesso
                showSuccessPopup()
            } else {
                if (!senhasIguais) {
                    textErroDiferente.visibility = View.VISIBLE
                    textErroDiferente.text = "As senhas não coincidem"
                } else {
                    textErroDiferente.visibility = View.GONE
                }

                if (!senhaValida) {
                    Toast.makeText(this, "A senha não atende aos requisitos", Toast.LENGTH_SHORT).show()
                    textErroRequisitos.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))
                } else {
                    textErroRequisitos.setTextColor(ContextCompat.getColor(this, android.R.color.darker_gray))
                }
            }
        }
    }

    private fun showSuccessPopup() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.telarf08_confirmar_redefinir_senha, null)
        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(true)

        val alertDialog = builder.create()

        val btnIrLogin = dialogView.findViewById<Button>(R.id.btnIrLogin)
        
        btnIrLogin.setOnClickListener {
            alertDialog.dismiss()
            val intent = Intent(this, TelaRF03LoginAluno::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }

        alertDialog.show()
    }

    private fun validarSenha(senha: String): Boolean {
        val temOitoDigitos = senha.length >= 8
        val temMaiuscula = senha.any { it.isUpperCase() }
        val temNumero = senha.any { it.isDigit() }
        return temOitoDigitos && temMaiuscula && temNumero
    }
}
