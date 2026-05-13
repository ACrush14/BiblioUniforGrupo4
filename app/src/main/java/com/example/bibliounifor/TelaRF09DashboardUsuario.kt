package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class TelaRF09DashboardUsuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf09_dashboardusuario)

        // Botões do Header
        val btnConfig = findViewById<ImageView>(R.id.btnConfig)
        val btnNotificacao = findViewById<ImageView>(R.id.btnNotificacao)
        val profileImage = findViewById<ImageView>(R.id.profile_image)
        val textNomeUsuario = findViewById<TextView>(R.id.textNomeUsuario)

        // Botões de Ações Rápidas (Cards/Buttons no ScrollView)
        val btnProcurarLivros = findViewById<MaterialButton>(R.id.btnProcurarLivros)
        val btnMinhaLivraria = findViewById<MaterialButton>(R.id.btnMinhaLivrariaDash)
        val btnListaDesejo = findViewById<MaterialButton>(R.id.btnListaDesejoDash)
        val btnAmigos = findViewById<MaterialButton>(R.id.btnAmigosDash)
        val btnHistorico = findViewById<MaterialButton>(R.id.btnHistoricoDash)
        val btnStatusAluguel = findViewById<MaterialButton>(R.id.btnStatusAluguelDash)
        val btnSalvar = findViewById<MaterialButton>(R.id.btnSalvarDash)
        val btnSair = findViewById<MaterialButton>(R.id.btnSairDash)

        // Navegação via Engrenagem -> Configuração (RF10)
        btnConfig.setOnClickListener {
            startActivity(Intent(this, TelaRF10Configuracao::class.java))
        }

        // ISSUE 1: Sininho (Notificações)
        btnNotificacao.setOnClickListener {
            startActivity(Intent(this, TelaRF21Notificacoes::class.java))
        }

        // Ações Rápidas
        btnProcurarLivros.setOnClickListener {
            startActivity(Intent(this, TelaRF12TelaDePesquisa::class.java))
        }

        btnMinhaLivraria.setOnClickListener {
            startActivity(Intent(this, TelaRF16MinhaLivrariaActivity::class.java))
        }

        btnListaDesejo.setOnClickListener {
            startActivity(Intent(this, TelaRF17ListaDesejosActivity::class.java))
        }

        btnAmigos.setOnClickListener {
            startActivity(Intent(this, TelaRF18::class.java))
        }

        btnHistorico.setOnClickListener {
            startActivity(Intent(this, TelaRF22Historico::class.java))
        }

        btnStatusAluguel.setOnClickListener {
            startActivity(Intent(this, TelaRF19::class.java))
        }

        // ISSUE 2: Popup Salvar Alterações
        btnSalvar.setOnClickListener {
            showSalvarSucessoPopup()
        }

        // ISSUE 3: Popup Sair da Conta
        btnSair.setOnClickListener {
            showSairContaPopup()
        }

        // ISSUE 4, 5 e 6: Configurar Livros do Dashboard (Includes)
        setupLivroDash(R.id.livro1)
        setupLivroDash(R.id.livro2)
        setupLivroDash(R.id.livro3)

        // 🔥 BARRA DE TAREFAS (BOTTOM NAV - USANDO UTILS)
        NavigationUtils.setupBottomNavigation(this)
    }

    private fun setupLivroDash(includeId: Int) {
        val layoutLivro = findViewById<View>(includeId)
        val imgLivro = layoutLivro.findViewById<ImageView>(R.id.imgLivro)
        val btnAlugar = layoutLivro.findViewById<Button>(R.id.btnAlugar)
        val btnComprar = layoutLivro.findViewById<Button>(R.id.btnComprar)

        // ISSUE 4: Abrir Tela do Livro
        imgLivro.setOnClickListener {
            startActivity(Intent(this, TelaRF13TelaDoLivro::class.java))
        }

        // ISSUE 5: Botão Alugar -> Solicitações
        btnAlugar.setOnClickListener {
            startActivity(Intent(this, TelaRF20Solicitacoes::class.java))
        }

        // ISSUE 6: Botão Comprar -> Lista de Desejos
        btnComprar.setOnClickListener {
            startActivity(Intent(this, TelaRF17ListaDesejosActivity::class.java))
        }
    }

    private fun showSalvarSucessoPopup() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.popup_salvar_sucesso, null)
        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(true)

        val alertDialog = builder.create()
        val btnOk = dialogView.findViewById<Button>(R.id.btnOk)

        btnOk.setOnClickListener {
            alertDialog.dismiss()
        }

        alertDialog.show()
    }

    private fun showSairContaPopup() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.popup_sair_conta, null)
        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(true)

        val alertDialog = builder.create()
        val btnConfirmar = dialogView.findViewById<Button>(R.id.btnConfirmarSair)
        val btnCancelar = dialogView.findViewById<TextView>(R.id.btnCancelarSair)

        btnConfirmar.setOnClickListener {
            alertDialog.dismiss()
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        btnCancelar.setOnClickListener {
            alertDialog.dismiss()
        }

        alertDialog.show()
    }
}
