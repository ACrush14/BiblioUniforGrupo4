package com.example.bibliounifor

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class TelaRF22Historico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf22_historico)

        // Padronização da Navegação e Cabeçalho
        NavigationUtils.setupTopBar(this)
        NavigationUtils.setupBottomNavigation(this)

        val buttonRemoverHistorico = findViewById<Button>(R.id.btnRemoverHIstorico)
        buttonRemoverHistorico?.setOnClickListener {
            showRemoverHistoricoPopup()
        }
    }

    private fun showRemoverHistoricoPopup() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.popup_rf21_remover_historico, null)
        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(true)

        val alertDialog = builder.create()

        // Configurar botão de remover (ID do XML: btnConfirmarRemover)
        val btnConfirmar = dialogView.findViewById<Button>(R.id.btnConfirmarRemover)
        btnConfirmar.setOnClickListener {
            // Simulação de remoção do histórico
            Toast.makeText(this, "Livro removido do histórico com sucesso!", Toast.LENGTH_SHORT).show()
            alertDialog.dismiss()
            
            // Aqui você pode adicionar a lógica para atualizar a lista se houver um adapter
        }

        // Configurar botão de cancelar (ID do XML: btnCancelarRemover)
        val btnCancelar = dialogView.findViewById<TextView>(R.id.btnCancelarRemover)
        btnCancelar.setOnClickListener {
            alertDialog.dismiss()
        }

        alertDialog.show()
    }
}
