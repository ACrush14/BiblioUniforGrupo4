package com.example.bibliounifornew 

class TelaRF22Historico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf22_historico)

        // Padronização da Navegação e Cabeçalho
        NavigationUtils.setupTopBar(this)
        NavigationUtils.setupBottomNavigation(this)

        val buttonRemoverHistorico = findViewById<Button>(R.id.btnRemoverHIstorico)
        buttonRemoverHistorico?.setOnClickListener {
            // Lógica para remover item do histórico
        }
    }
}