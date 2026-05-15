package com.example.bibliounifornew.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.bibliounifornew.R

class TelaRF07RedefinirSenha : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf07_redefinicao_de_senha)

        val editSenhaNova = findViewById<EditText>(R.id.editSenhaNova)
        val editConfirmarSenha = findViewById<EditText>(R.id.editConfirmarSenha)
        val btnConfirmar = findViewById<Button>(R.id.editConfirmarSenha)

        val textErroDiferente = findViewById<TextView>(R.id.textErroDiferente)
        val textErroRequisitos = findViewById<TextView>(R.id.textErroSenha2)

        // Inicializa erros como invisíveis ou cor padrão
        textErroDiferente.visibility = View.GONE

        btnConfirmar.setOnClickListener {
            val senhanova = editSenhaNova.text.toString()
            val confirmarsenha = editConfirmarSenha.text.toString()

            val senhaValida = validarSenha(senhanova)
            val senhasIguais = senhanova == confirmarsenha

            if (senhaValida && senhasIguais) {
                // Simulação de atualização no Banco de Dados
                Toast.makeText(this, "Senha redefinida com sucesso", Toast.LENGTH_LONG).show()

                // Vai para a tela de login
                val intent = Intent(this, TelaRF03LoginAluno::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
                finish()
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

    private fun validarSenha(senha: String): Boolean {
        val temOitoDigitos = senha.length >= 8
        val temMaiuscula = senha.any { it.isUpperCase() }
        val temNumero = senha.any { it.isDigit() }
        return temOitoDigitos && temMaiuscula && temNumero
    }
}