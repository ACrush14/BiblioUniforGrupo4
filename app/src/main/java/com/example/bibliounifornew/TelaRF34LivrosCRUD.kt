package com.example.bibliounifornew 

class TelaRF34LivrosCRUD : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf34_livroscrud)

        // 🔹 Botão Criar Mídia
        val btnCriarMidia = findViewById<Button>(R.id.btnCriarMidia)
        btnCriarMidia?.setOnClickListener {
            val intent = Intent(this, TelaRF35CadastroDeLivros::class.java)
            startActivity(intent)
        }

        // 🔹 Botão Editar
        findViewById<Button>(R.id.btnEditarInformacoes)?.setOnClickListener {
            val intent = Intent(this, TelaRF35CadastroDeLivros::class.java)
            startActivity(intent)
        }

        // 👇 BARRA ADM PADRONIZADA
        NavigationUtils.setupAdminNavigation(this)
    }
}