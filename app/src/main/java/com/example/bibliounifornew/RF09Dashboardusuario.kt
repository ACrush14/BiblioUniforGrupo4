package com.example.bibliounifor

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class RF09DashboardUsuario : AppCompatActivity() {

    lateinit var navHome: ImageView
    lateinit var navUsuario: ImageView
    lateinit var navBusca: ImageView
    lateinit var navCarrinho: ImageView
    lateinit var navFavoritos: ImageView
    lateinit var navLista: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.telarf09_dashboardusuario)

        navHome = findViewById(R.id.navHome)
        navUsuario = findViewById(R.id.navUsuario)
        navBusca = findViewById(R.id.navBusca)
        navCarrinho = findViewById(R.id.navCarrinho)
        navFavoritos = findViewById(R.id.navFavoritos)
        navLista = findViewById(R.id.navLista)
    }
}
