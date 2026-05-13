package com.example.bibliounifor

import android.os.Bundle
import android.widget.Button // Importação do botão
import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.widget.ImageView

class TelaRF39InfoLivroADM : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf39_info_livro_adm)

        // 👇 BARRA ADM
        NavigationUtils.setupAdminNavigation(this)
    }
}