package com.example.bibliounifornew

import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TelaRF27RedefinirSenhaADM : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf27_redefinir_senha_adm)

        val edtNovaSenha = findViewById<EditText>(R.id.editSenhaNova)
        val edtConfirmar = findViewById<EditText>(R.id.editConfirmarSenha)
        val txtErroSenhasDiferentes = findViewById<TextView>(R.id.textErroSenhaDiferente)
        val btnRedefinir = findViewById<Button>(R.id.buttonRedefinirSenha)
        
        // Find by ID manually if missing, but let's assume it might not exist yet based on layout
        // In the layout I just wrote, I didn't see a "textVoltar". Let me re-check layout.
        // Actually, there's no textVoltar in the XML I just wrote. 
        // I'll stick to what's in the layout.

        val iconOlhoNova = findViewById<ImageView>(R.id.iconOlhoSenhaNova)
        val iconOlhoConfirmar = findViewById<ImageView>(R.id.iconOlhoConfirmarSenha)

        var senhaNovaVisivel = false
        iconOlhoNova.setOnClickListener {
            senhaNovaVisivel = !senhaNovaVisivel
            if (senhaNovaVisivel) {
                edtNovaSenha.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                iconOlhoNova.setImageResource(android.R.drawable.ic_menu_view) // Or your custom hidden icon
            } else {
                edtNovaSenha.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                iconOlhoNova.setImageResource(android.R.drawable.ic_menu_view)
            }
            edtNovaSenha.setSelection(edtNovaSenha.text.length)
        }

        var senhaConfirmarVisivel = false
        iconOlhoConfirmar.setOnClickListener {
            senhaConfirmarVisivel = !senhaConfirmarVisivel
            if (senhaConfirmarVisivel) {
                edtConfirmar.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            } else {
                edtConfirmar.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
            edtConfirmar.setSelection(edtConfirmar.text.length)
        }

        btnRedefinir.setOnClickListener {
            val senha1 = edtNovaSenha.text.toString()
            val senha2 = edtConfirmar.text.toString()

            if (senha1.isEmpty() || senha2.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha as duas senhas.", Toast.LENGTH_SHORT).show()
            } else if (senha1 != senha2) {
                txtErroSenhasDiferentes.visibility = View.VISIBLE
            } else {
                txtErroSenhasDiferentes.visibility = View.INVISIBLE
                Toast.makeText(this, "Senha alterada com sucesso!", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}
