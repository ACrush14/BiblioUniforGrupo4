package com.example.bibliounifor

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class TelaRF35_4Versoes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf35_4_versoes)

        val btnSalvarLivro = findViewById<MaterialButton>(R.id.btnSalvarLivro)

        btnSalvarLivro.setOnClickListener {
            exibirPopupSucesso()
        }

        // 👇 BARRA ADM
        NavigationUtils.setupAdminNavigation(this)
    }

    private fun exibirPopupSucesso() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.telarf35_6_popup_sucesso, null)
        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(true)

        val dialog = builder.create()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        dialog.show()
    }
}