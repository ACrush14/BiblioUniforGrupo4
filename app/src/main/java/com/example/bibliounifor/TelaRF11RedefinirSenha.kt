package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class TelaRF11RedefinirSenha : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf11_redefinirsenha)

        // CAMPOS
        val editNovaSenha = findViewById<EditText>(R.id.editNovaSenha)
        val editConfirmarSenha = findViewById<EditText>(R.id.editConfirmarSenha)
        val btnSalvar = findViewById<MaterialButton>(R.id.buttonSalvar)

        // MENSAGENS DE ERRO
        val erroObrigatorio = findViewById<TextView>(R.id.textErroSenha)
        val erroAntiga = findViewById<TextView>(R.id.textErroSenhaAntiga)
        val erroCaracteres = findViewById<TextView>(R.id.textErroSenhaCaracteres)
        val erroNumero = findViewById<TextView>(R.id.textErroSenhaNumero)
        val erroMaiuscula = findViewById<TextView>(R.id.textErroSenhaMaiuscula)
        val erroConfirmar = findViewById<TextView>(R.id.textErroConfirmar)

        // HEADER
        val textHeaderNome = findViewById<TextView>(R.id.textHeaderNome)
        val textHeaderEmail = findViewById<TextView>(R.id.textHeaderEmail)
        
        // Simulação de dados do usuário
        textHeaderNome.text = "João Bobo"
        textHeaderEmail.text = "joao.bobo@email.com"

        // 🔥 VALIDAÇÃO + SALVAR
        btnSalvar.setOnClickListener {
            val senha = editNovaSenha.text.toString()
            val confirmar = editConfirmarSenha.text.toString()

            // Resetar visibilidade dos erros
            erroObrigatorio.visibility = View.GONE
            erroAntiga.visibility = View.GONE
            erroCaracteres.visibility = View.GONE
            erroNumero.visibility = View.GONE
            erroMaiuscula.visibility = View.GONE
            erroConfirmar.visibility = View.GONE

            var valido = true

            // 1. Campo obrigatório
            if (senha.isEmpty()) {
                erroObrigatorio.visibility = View.VISIBLE
                valido = false
            } else {
                // 2. Senha antiga (Simulação: antiga era "12345678")
                if (senha == "12345678") {
                    erroAntiga.visibility = View.VISIBLE
                    valido = false
                }

                // 3. Mínimo 8 caracteres
                if (senha.length < 8) {
                    erroCaracteres.visibility = View.VISIBLE
                    valido = false
                }

                // 4. Um número
                if (!senha.any { it.isDigit() }) {
                    erroNumero.visibility = View.VISIBLE
                    valido = false
                }

                // 5. Uma letra maiúscula
                if (!senha.any { it.isUpperCase() }) {
                    erroMaiuscula.visibility = View.VISIBLE
                    valido = false
                }
            }

            // 6. Confirmação diferente
            if (senha != confirmar && confirmar.isNotEmpty()) {
                erroConfirmar.visibility = View.VISIBLE
                valido = false
            } else if (confirmar.isEmpty() && senha.isNotEmpty()) {
                erroConfirmar.visibility = View.VISIBLE
                erroConfirmar.text = "Confirme sua senha"
                valido = false
            }

            if (valido) {
                showSuccessPopup()
            }
        }

        // 🔥 BARRA DE TAREFAS
        NavigationUtils.setupBottomNavigation(this)
        
        // Configuração manual dos ícones caso o Utils não cubra todos os cliques
        findViewById<ImageView>(R.id.navHome).setOnClickListener {
            startActivity(Intent(this, TelaRF09DashboardUsuario::class.java))
        }
        findViewById<ImageView>(R.id.navUsuario).setOnClickListener {
            startActivity(Intent(this, TelaRF18::class.java))
        }
    }

    private fun showSuccessPopup() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.popup_salvar_sucesso, null)
        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(true)

        val alertDialog = builder.create()
        
        val tvMensagem = dialogView.findViewById<TextView>(R.id.tvMensagem)
        tvMensagem.text = "Alterações salvas com sucesso!"
        
        val btnOk = dialogView.findViewById<Button>(R.id.btnOk)
        btnOk.text = "Voltar"

        btnOk.setOnClickListener {
            alertDialog.dismiss()
            val intent = Intent(this, TelaRF10Configuracao::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }

        alertDialog.show()
    }
}
