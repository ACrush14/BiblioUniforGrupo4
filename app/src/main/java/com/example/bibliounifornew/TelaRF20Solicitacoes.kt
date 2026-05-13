package com.example.bibliounifornew 

class TelaRF20Solicitacoes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf20_solicitacoes)

        // Padronização da Navegação e Cabeçalho
        NavigationUtils.setupTopBar(this)
        NavigationUtils.setupBottomNavigation(this)

        // 1. Localizar os botões pelos IDs do XML
        val btnPdf = findViewById<Button>(R.id.btnSolicitarPdf)
        val btnBraile = findViewById<Button>(R.id.btnSolicitarBraile)
        val btnAudio = findViewById<Button>(R.id.btnSolicitarAudiobook)
        val btnReservar = findViewById<Button>(R.id.btnReservar)
        val btnSetor = findViewById<Button>(R.id.btnSetorLocalizado)

        // 2. Configurar apenas o botão PDF para levar aos Termos e Condições
        btnPdf.setOnClickListener {
            val intent = Intent(this, TelaRF20SolicitacoesTermosCondicoes::class.java)
            startActivity(intent)
        }

        btnSetor.setOnClickListener {
            Toast.makeText(
                this,
                "Setor do livro O Alienista: Setor X",
                Toast.LENGTH_SHORT
            ).show()
        }

        // 3. Os outros botões ficam sem ação definida por enquanto
        btnBraile.setOnClickListener { /* Sem ação */ }
        btnAudio.setOnClickListener { /* Sem ação */ }
        btnReservar.setOnClickListener { /* Sem ação */ }
    }
}