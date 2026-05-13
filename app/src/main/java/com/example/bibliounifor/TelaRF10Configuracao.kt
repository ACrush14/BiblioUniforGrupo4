package com.example.bibliounifor

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class TelaRF10Configuracao : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf10_configuracao)

        val btnRedefinir = findViewById<MaterialButton>(R.id.btnRedefinirSenha)
        val btnApagar = findViewById<MaterialButton>(R.id.btnApagarConta)

        btnRedefinir.setOnClickListener {
            val intent = Intent(this, TelaRF11RedefinirSenha::class.java)
            startActivity(intent)
        }

        btnApagar.setOnClickListener {
            abrirPopupApagarConta()
        }

        // LÓGICA PARA EDITAR USUÁRIO
        val btnEditarUsuario = findViewById<ImageView>(R.id.btnEditarUsuario)
        val textUsuario = findViewById<TextView>(R.id.textUsuario)

        btnEditarUsuario.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Editar Usuário")

            // Criar um EditText dinamicamente para o popup
            val input = EditText(this)
            input.hint = "Digite o novo nome ou email"
            input.setText(textUsuario.text)
            builder.setView(input)

            builder.setPositiveButton("Salvar") { dialog, _ ->
                val novoNome = input.text.toString().trim()
                if (novoNome.isNotEmpty()) {
                    textUsuario.text = novoNome
                }
                dialog.dismiss()
            }

            builder.setNegativeButton("Cancelar") { dialog, _ ->
                dialog.cancel()
            }

            builder.show()
        }

        // 🔥 BARRA DE TAREFAS (BOTTOM NAV)
        NavigationUtils.setupBottomNavigation(this)
    }

    private fun abrirPopupApagarConta() {
        val viewPopup = layoutInflater.inflate(R.layout.telarf10_10_apagar_conta, null)

        val editSenha = viewPopup.findViewById<EditText>(R.id.editSenhaPopup)
        val textErro = viewPopup.findViewById<TextView>(R.id.textErroPopup)
        val iconOlho = viewPopup.findViewById<ImageView>(R.id.iconOlho)
        val btnConfirmarPopup = viewPopup.findViewById<Button>(R.id.btnConfirmarPopup)

        val dialog = AlertDialog.Builder(this)
            .setView(viewPopup)
            .setCancelable(false)
            .create()

        dialog.show()

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        btnConfirmarPopup.setOnClickListener {
            val senha = editSenha.text.toString().trim()

            if (senha.isEmpty()) {
                textErro.visibility = View.VISIBLE
            } else {
                textErro.visibility = View.GONE

                // Aqui futuramente entra a lógica real para apagar a conta.
                dialog.dismiss()
            }
        }

        var senhaVisivel = false

        iconOlho.setOnClickListener {
            senhaVisivel = !senhaVisivel

            if (senhaVisivel) {
                editSenha.inputType = InputType.TYPE_CLASS_TEXT or
                        InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            } else {
                editSenha.inputType = InputType.TYPE_CLASS_TEXT or
                        InputType.TYPE_TEXT_VARIATION_PASSWORD
            }

            editSenha.setSelection(editSenha.text.length)
        }

        editSenha.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                textErro.visibility = View.GONE
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }
}