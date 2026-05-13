package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.bibliounifor.data.AppDatabase
import com.example.bibliounifor.data.Usuario
import kotlinx.coroutines.launch

class TelaRF05CadastroNovoUsuario : AppCompatActivity() {

    private lateinit var etNome: EditText
    private lateinit var etUsuario: EditText
    private lateinit var etEmail: EditText
    private lateinit var etSenha: EditText
    private lateinit var etConfirmaSenha: EditText
    private lateinit var tvErroEmail: TextView
    private lateinit var tvErroSenha: TextView
    private lateinit var btnCriar: Button
    private lateinit var btnEntreAqui: TextView

    private val db by lazy { AppDatabase.getDatabase(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.telarf04_cadastrar_novo_usuario)

        etNome = findViewById(R.id.editTextNome)
        etUsuario = findViewById(R.id.editTextUsuario)
        etEmail = findViewById(R.id.editTextEmail)
        etSenha = findViewById(R.id.editTextSenha)
        etConfirmaSenha = findViewById(R.id.editTextConfirmaSenha)
        tvErroEmail = findViewById(R.id.tvErroEmail)
        tvErroSenha = findViewById(R.id.tvErroSenha)
        btnEntreAqui = findViewById(R.id.textEntreAqui)
        btnCriar = findViewById(R.id.btnCriar)

        // MOSTRAR/OCULTAR SENHA
        val iconOlhoSenha = findViewById<ImageView>(R.id.iconOlhoSenha)
        val iconOlhoConfirma = findViewById<ImageView>(R.id.iconOlhoConfirmarSenha)

        var senhaVisivel = false
        iconOlhoSenha.setOnClickListener {
            senhaVisivel = !senhaVisivel
            if (senhaVisivel) {
                etSenha.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            } else {
                etSenha.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
            etSenha.setSelection(etSenha.text.length)
        }

        var confirmaVisivel = false
        iconOlhoConfirma.setOnClickListener {
            confirmaVisivel = !confirmaVisivel
            if (confirmaVisivel) {
                etConfirmaSenha.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            } else {
                etConfirmaSenha.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
            etConfirmaSenha.setSelection(etConfirmaSenha.text.length)
        }

        btnCriar.setOnClickListener {
            validarECadastrar()
        }

        btnEntreAqui.setOnClickListener {
            irParaLogin()
        }
    }

    private fun validarECadastrar() {
        val email = etEmail.text.toString().trim()
        val senha = etSenha.text.toString()
        val confirmaSenha = etConfirmaSenha.text.toString()

        var valido = true
        tvErroEmail.visibility = View.GONE
        tvErroSenha.visibility = View.GONE

        // Validar E-mail
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            tvErroEmail.text = "E-mail inválido"
            tvErroEmail.visibility = View.VISIBLE
            valido = false
        }

        // Validar Senha (8 caracteres, 1 número, 1 maiúscula)
        val senhaRegex = "^(?=.*[0-9])(?=.*[A-Z]).{8,}$".toRegex()
        if (!senhaRegex.matches(senha)) {
            tvErroSenha.visibility = View.VISIBLE
            valido = false
        } else if (senha != confirmaSenha) {
            tvErroSenha.text = "As senhas não coincidem"
            tvErroSenha.visibility = View.VISIBLE
            valido = false
        }

        if (valido) {
            lifecycleScope.launch {
                val usuarioExistente = db.usuarioDao().buscarPorEmail(email)
                if (usuarioExistente != null) {
                    tvErroEmail.text = "E-mail já cadastrado"
                    tvErroEmail.visibility = View.VISIBLE
                } else {
                    db.usuarioDao().inserir(Usuario(
                        nome = etNome.text.toString(),
                        usuario = etUsuario.text.toString(),
                        email = email,
                        senha = senha
                    ))
                    mostrarPopupSucesso()
                }
            }
        }
    }

    private fun mostrarPopupSucesso() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.popup_sucesso_cadastro, null)
        val dialog = AlertDialog.Builder(this, R.style.CustomAlertDialog)
            .setView(dialogView)
            .setCancelable(true)
            .create()

        dialog.setOnDismissListener {
            irParaLogin()
        }
        dialog.show()
    }

    private fun irParaLogin() {
        val intent = Intent(this, TelaRF03LoginAluno::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finish()
    }
}
