package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.bibliounifor.data.AppDatabase
import kotlinx.coroutines.launch

class TelaRF03LoginAluno : AppCompatActivity() {

    private val db by lazy { AppDatabase.getDatabase(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf03_loginaluno)

        // CAMPOS
        val email = findViewById<EditText>(R.id.editEmail)
        val senha = findViewById<EditText>(R.id.editSenha)

        // BOTÃO
        val botaoEntrar = findViewById<Button>(R.id.buttonEntrar)

        // TEXTOS
        val erro = findViewById<TextView>(R.id.textErroLogin)
        val criarConta = findViewById<TextView>(R.id.textCriarConta)
        val esqueceuSenha = findViewById<TextView>(R.id.textEsqueceuSenha)

        // LOGIN
        botaoEntrar.setOnClickListener {

            val textoEmail = email.text.toString().trim()
            val textoSenha = senha.text.toString().trim()

            erro.visibility = View.GONE

            if (textoEmail.isEmpty() || textoSenha.isEmpty()) {
                erro.text = "Preencha todos os campos"
                erro.visibility = View.VISIBLE
                return@setOnClickListener
            }

            lifecycleScope.launch {
                val usuario = db.usuarioDao().autenticar(textoEmail, textoSenha)
                
                if (usuario != null) {
                    Toast.makeText(this@TelaRF03LoginAluno, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@TelaRF03LoginAluno, TelaRF09DashboardUsuario::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // Fallback para usuários mockados legados para não quebrar testes rápidos
                    val usuariosValidos = mapOf(
                        "teste@email.com" to "12345678",
                        "anderson.link.crush@hotmail.com" to "123456"
                    )
                    
                    if (usuariosValidos[textoEmail] == textoSenha) {
                        Toast.makeText(this@TelaRF03LoginAluno, "Login realizado com sucesso (Mock)!", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@TelaRF03LoginAluno, TelaRF09DashboardUsuario::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        erro.text = "E-mail ou senha incorretos"
                        erro.visibility = View.VISIBLE
                    }
                }
            }
        }

        // CRIAR CONTA -> TelaRF05
        criarConta.setOnClickListener {
            val intent = Intent(this, TelaRF05CadastroNovoUsuario::class.java)
            startActivity(intent)
        }

        // ESQUECEU SENHA -> TelaRF06
        esqueceuSenha.setOnClickListener {
            val intent = Intent(this, TelaRF06RecuperacaoSenha::class.java)
            startActivity(intent)
        }

        // UX MELHORADA (remove erro ao focar)
        email.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) erro.visibility = View.GONE
        }

        senha.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) erro.visibility = View.GONE
        }
    }
}