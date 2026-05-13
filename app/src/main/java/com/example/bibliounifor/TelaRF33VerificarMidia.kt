package com.example.bibliounifor

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

        val btnFiltro = findViewById<ImageView>(R.id.btnFiltro)
        val btnEnviarAudio = findViewById<Button>(R.id.btnEnviarAudio)
        val btnEnviarPdf = findViewById<Button>(R.id.btnEnviarPdf)
        val btnBraille = findViewById<Button>(R.id.btnBraille)
        val btnExcluirSolicitacao = findViewById<Button>(R.id.btnExcluirSolicitacao)

        // =========================
        // ABRIR POPUPS
        // =========================

        btnFiltro.setOnClickListener {
            startActivity(Intent(this, TelaRF332Filtro::class.java))
        }

        btnEnviarAudio.setOnClickListener {
            startActivity(Intent(this, TelaRF335UsuarioNotificado::class.java))
        }

        btnEnviarPdf.setOnClickListener {
            // Reutiliza o popup de notificação conforme padrão
            startActivity(Intent(this, TelaRF335UsuarioNotificado::class.java))
        }

        btnBraille.setOnClickListener {
            startActivity(Intent(this, TelaRF336BrailleConcluido::class.java))
        }

        btnExcluirSolicitacao.setOnClickListener {
            startActivity(Intent(this, TelaRF337ExcluirSolicitacao::class.java))
        }

        // =========================
        // BARRA ADM (Utilizando o padrão do projeto)
        // =========================
        NavigationUtils.setupAdminNavigation(this)
    }
}
