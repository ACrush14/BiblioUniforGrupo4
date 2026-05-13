package com.example.bibliounifor

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TelaRF337ExcluirSolicitacao : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.popup_rf33_7_excluir_solicitacao
        )

        // BOTÕES

        val btnConfirmarExcluir =
            findViewById<Button>(R.id.btnConfirmarExcluir)

        // EXCLUIR

        btnConfirmarExcluir.setOnClickListener {

            finish()
        }
    }
}