package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class TelaRF40ConfigADM : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf40_config_adm)

        // 👇 Padronização da Navegação ADM
        NavigationUtils.setupAdminNavigation(this)

        // MOSTRAR/OCULTAR SENHA
        val editSenhaAtual = findViewById<EditText>(R.id.editSenhaAtual)
        val iconOlho = findViewById<ImageView>(R.id.iconOlhoSenhaAtual)
        var senhaVisivel = false

        iconOlho?.setOnClickListener {
            senhaVisivel = !senhaVisivel
            if (senhaVisivel) {
                editSenhaAtual?.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            } else {
                editSenhaAtual?.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
            editSenhaAtual?.setSelection(editSenhaAtual.text.length)
        }

        // Botões específicos da tela de configuração
        val btnRedefinirSenha = findViewById<MaterialButton>(R.id.btnRedefinirSenha)
        val btnApagarConta = findViewById<MaterialButton>(R.id.btnApagarConta)

        btnRedefinirSenha?.setOnClickListener {
            val intent = Intent(this, TelaRF41RedefinirADMInterno::class.java)
            startActivity(intent)
        }
        
        btnApagarConta?.setOnClickListener {
            // Lógica para apagar conta ou logout
            val intent = Intent(this, TelaRF02Intermediaria::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}
