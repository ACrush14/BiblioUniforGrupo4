package com.example.bibliounifornew 

class TelaRF38ListaAlugueisADM : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.telarf38_lista_alugueis_adm)

        // 👇 BARRA ADM
        NavigationUtils.setupAdminNavigation(this)

        // 1. Encontrar o botão pelo ID que está no XML
        val botaoVerLivro1 = findViewById<Button>(R.id.btnVerLivro1)

        // 2. Criar a ação de clique
        botaoVerLivro1.setOnClickListener {
            // 3. Fazer a ponte (Intent) para a Tela 39
            val intent = Intent(this, TelaRF39InfoLivroADM::class.java)
            startActivity(intent)
        }
    }
}