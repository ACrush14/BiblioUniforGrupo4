package com.example.bibliounifor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class TelaRF16MinhaLivrariaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf16_minha_livraria)

        NavigationUtils.setupBottomNavigation(this)
        NavigationUtils.setupTopBar(this)
    }
}
