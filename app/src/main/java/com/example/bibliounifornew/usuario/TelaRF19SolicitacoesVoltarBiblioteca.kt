package com.example.bibliounifornew.usuario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.bibliounifornew.R

class TelaRF19SolicitacoesVoltarBiblioteca : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf19_solicitacoes_voltar_biblioteca)

        val buttonVoltarBiblioteca = findViewById<Button>(R.id.buttonPopupOkSolicitacao)

        buttonVoltarBiblioteca.setOnClickListener {
            val intent =
                Intent(this@TelaRF19SolicitacoesVoltarBiblioteca, TelaRF12TelaDoLivro::class.java)
            startActivity(intent)
        }


    }
}