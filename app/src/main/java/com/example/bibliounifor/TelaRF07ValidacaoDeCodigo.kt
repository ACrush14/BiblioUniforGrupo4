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

class TelaRF07ValidacaoDeCodigo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf07_validacao_de_codigo)

        val editCodigo = findViewById<EditText>(R.id.editCodigo)
        val textErro = findViewById<TextView>(R.id.textErro)
        val buttonEnviarCodigo = findViewById<Button>(R.id.btnEnviarCodigo)
        
        val isADM = intent.getBooleanExtra("isADM", false)

        textErro.visibility = View.INVISIBLE

        buttonEnviarCodigo.setOnClickListener {
            val codigoDigitado = editCodigo.text.toString()

            // Simulação de código correto (ex: 123456)
            if (codigoDigitado == "123456") {
                textErro.visibility = View.INVISIBLE
                showConfirmationPopup(isADM)
            } else {
                textErro.visibility = View.VISIBLE
                textErro.text = "Código incorreto. Verifique seu e-mail."
            }
        }
    }

    private fun showConfirmationPopup(isADM: Boolean) {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.telarf08_confirmar_redefinir_senha, null)
        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(true)

        val alertDialog = builder.create()
        
        val btnIrLogin = dialogView.findViewById<Button>(R.id.btnIrLogin)
        btnIrLogin.text = "Prosseguir"

        btnIrLogin.setOnClickListener {
            alertDialog.dismiss()
            if (isADM) {
                val intent = Intent(this, TelaRF27RedefinirSenhaADM::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, TelaRF08RedefinirSenha::class.java)
                startActivity(intent)
            }
            finish()
        }

        alertDialog.show()
    }
}
