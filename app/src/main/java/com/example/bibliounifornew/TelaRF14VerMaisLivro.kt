package com.example.bibliounifornew 

class TelaRF14VerMaisLivro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf14_telavermaislivro)

        // Padronização da Navegação e Cabeçalho
        NavigationUtils.setupTopBar(this)
        NavigationUtils.setupBottomNavigation(this)

        // Configura o botão voltar (ID: materialButton22 no XML)
        findViewById<Button>(R.id.materialButton22).setOnClickListener {
            finish()
        }
    }
}