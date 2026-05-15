package com.example.bibliounifornew.usuario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bibliounifornew.R
import com.example.bibliounifornew.usuario.TelaRF20SolicitacoesVoltarBiblioteca

class TelaRF20SolicitacoesTermosCondicoes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.telarf20_solicitacoes_termos_condicoes)

        val checkBox = findViewById<CheckBox>(R.id.checkTelaAceitarTermos)
        val buttonContinuar = findViewById<Button>(R.id.buttonConfirmarTermosTela)

        buttonContinuar.setOnClickListener {
            if (checkBox.isChecked) {
                // Caminho: Termos -> Voltar Biblioteca
                val intent = Intent(this, TelaRF20SolicitacoesVoltarBiblioteca::class.java)
                startActivity(intent)
            } else {
                // Aviso caso não marque a caixa
                Toast.makeText(this, "Por favor, aceite os termos para continuar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}