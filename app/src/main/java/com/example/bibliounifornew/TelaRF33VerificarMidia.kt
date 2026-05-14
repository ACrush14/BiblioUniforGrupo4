package com.example.bibliounifornew

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class TelaRF33VerificarMidia : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf33_verificar_midia)

        // =========================
        // BOTÕES DA TELA
        // =========================

        val btnFiltro = findViewById<ImageView>(R.id.buttonFiltroMidia)
        val btnSolicitacoesUsuario = findViewById<Button>(R.id.buttonVerSolicitacoesUsuario)
        val btnEnviarAudio = findViewById<Button>(R.id.buttonEnviarAudiobook)
        val btnEnviarPdf = findViewById<Button>(R.id.buttonEnviarPDF)
        val btnBraille = findViewById<Button>(R.id.buttonBrailleConcluido)
        val btnExcluirSolicitacao = findViewById<Button>(R.id.buttonExcluirSolicitacao)

        // =========================
        // ABRIR POPUPS
        // =========================

        btnFiltro.setOnClickListener {
            startActivity(Intent(this, TelaRF332Filtro::class.java))
        }

        btnSolicitacoesUsuario.setOnClickListener {
            // Volta para a lista ou tela anterior de solicitações
            finish()
        }

        btnEnviarAudio.setOnClickListener {
            startActivity(Intent(this, PopupNotificacaoBrailleConcluido::class.java))
        }

        btnEnviarPdf.setOnClickListener {
            // Reutiliza o popup de notificação conforme padrão
            startActivity(Intent(this, PopupNotificacaoBrailleConcluido::class.java))
        }

        btnBraille.setOnClickListener {
            startActivity(Intent(this, PopupNotificacaoBrailleConcluido::class.java))
        }

        btnExcluirSolicitacao.setOnClickListener {
            startActivity(Intent(this, PopupConfirmarExclusaoSolicitacao::class.java))
        }

        // =========================
        // BARRA ADM (Utilizando o padrão do projeto)
        // =========================
        NavigationUtils.setupAdminNavigation(this)
    }
}