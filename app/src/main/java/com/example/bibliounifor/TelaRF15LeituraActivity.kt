package com.example.bibliounifor

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class TelaRF15LeituraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf15_leitura)

        // Padronização da Navegação
        NavigationUtils.setupBottomNavigation(this)

        val livroId = intent.getIntExtra("LIVRO_ID", -1)

        setupListeners(livroId)
    }

    private fun setupListeners(livroId: Int) {
        // PROCURAR
        findViewById<Button>(R.id.buttonProcurarLivro).setOnClickListener {
            val intent = Intent(this, TelaRF13TelaDoLivro::class.java)
            intent.putExtra("LIVRO_ID", livroId)
            startActivity(intent)
            finish()
        }

        // ABRIR PDF
        findViewById<Button>(R.id.buttonAbrirPdfLivro).setOnClickListener {
            val intent = Intent(this, TelaLivroBtnPdf::class.java)
            startActivity(intent)
        }

        // ABRIR AUDIOBOOK
        findViewById<Button>(R.id.buttonAbrirAudioLivro).setOnClickListener {
            val intent = Intent(this, TelaLivroBtnAudiobook::class.java)
            startActivity(intent)
        }

        // RESERVAR
        findViewById<Button>(R.id.buttonReservarLivro).setOnClickListener {
            showTermosCondicoesPopup()
        }

        // SETOR LOCALIZADO
        findViewById<Button>(R.id.buttonSetorLivro).setOnClickListener {
            showSetorPopup()
        }

        // ALUGAR (Opcional, se quiser implementar algo)
        findViewById<Button>(R.id.buttonAlugarLivro).setOnClickListener {
            Toast.makeText(this, "Funcionalidade de Alugar em desenvolvimento", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showTermosCondicoesPopup() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.telarf20_solicitacoes_termos_condicoes, null)
        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(true)

        val alertDialog = builder.create()
        
        val btnContinuar = dialogView.findViewById<Button>(R.id.btnContinuarSolicitacoes)
        val checkBox = dialogView.findViewById<CheckBox>(R.id.checkSolicitacoes)

        btnContinuar.setOnClickListener {
            if (checkBox.isChecked) {
                alertDialog.dismiss()
                showSucessoReservaPopup()
            } else {
                Toast.makeText(this, "Aceite os termos para continuar", Toast.LENGTH_SHORT).show()
            }
        }

        alertDialog.show()
    }

    private fun showSucessoReservaPopup() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.telarf20_solicitacoes_voltar_biblioteca, null)
        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(true)

        val alertDialog = builder.create()

        val btnVoltar = dialogView.findViewById<Button>(R.id.btnVoltarBiblioteca)
        
        btnVoltar.setOnClickListener {
            alertDialog.dismiss()
            // Volta para a biblioteca ou Dashboard
            startActivity(Intent(this, TelaRF09DashboardUsuario::class.java))
            finish()
        }

        alertDialog.show()
    }

    private fun showSetorPopup() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Setor do Livro: O Alienista")
        builder.setMessage("Setor X")
        builder.setPositiveButton("Voltar") { dialog, _ ->
            dialog.dismiss()
        }
        builder.create().show()
    }
}
