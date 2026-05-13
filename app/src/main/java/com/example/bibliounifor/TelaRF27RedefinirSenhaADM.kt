package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class TelaRF27RedefinirSenhaADM : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf27_redefinir_senha_adm)

        val edtNovaSenha = findViewById<EditText>(R.id.editTextTextPassword)
        val edtConfirmar = findViewById<EditText>(R.id.editTextTextPassword2)
        val txtErroSenhasDiferentes = findViewById<TextView>(R.id.textViewErro2)
        val btnRedefinir = findViewById<Button>(R.id.btnRedefinirSenha)

        btnRedefinir.setOnClickListener {
            val senha1 = edtNovaSenha.text.toString()
            val senha2 = edtConfirmar.text.toString()

            if (senha1.isEmpty() || senha2.isEmpty()) {
                txtErroSenhasDiferentes.visibility = View.VISIBLE
                txtErroSenhasDiferentes.text = "Preencha todos os campos"
            } else if (senha1 != senha2) {
                txtErroSenhasDiferentes.visibility = View.VISIBLE
                txtErroSenhasDiferentes.text = "As senhas não coincidem"
            } else {
                txtErroSenhasDiferentes.visibility = View.INVISIBLE
                showSuccessPopup()
            }
        }
    }

    private fun showSuccessPopup() {
        // Reutilizando o layout de sucesso (telarf08_confirmar_redefinir_senha servirá como base visual)
        val dialogView = LayoutInflater.from(this).inflate(R.layout.telarf08_confirmar_redefinir_senha, null)
        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(true)

        val alertDialog = builder.create()
        
        val tvDesc = dialogView.findViewById<TextView>(R.id.tvDesc)
        tvDesc.text = "Senha de administrador redefinida com sucesso!"
        
        val btnIrLogin = dialogView.findViewById<Button>(R.id.btnIrLogin)
        btnIrLogin.text = "Voltar ao Login ADM"

        btnIrLogin.setOnClickListener {
            alertDialog.dismiss()
            val intent = Intent(this, TelaRF24::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }

        alertDialog.show()
    }
}
