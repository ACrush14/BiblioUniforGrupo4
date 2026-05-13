package com.example.bibliounifornew 

class TelaRF32UsuariosParaADM : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 🔹 Nome do XML CORRETO
        setContentView(R.layout.telarf32_usuariosparaadm)

        // Padronização da Navegação ADM
        NavigationUtils.setupAdminTopBar(this)
        NavigationUtils.setupAdminBottomNavigation(this)

        // Botões (IDs do seu XML)
        val btnSolicitacoes = findViewById<Button>(R.id.btnSolicitacoes)
        val btnAlugados = findViewById<Button>(R.id.btnAlugados)
        val btnAtrasos = findViewById<Button>(R.id.btnAtrasos)
        val btnExcluirConta = findViewById<Button>(R.id.btnExcluirConta)

        // Abrir RF33 (Solicitações)
        btnSolicitacoes?.setOnClickListener {
            val intent = Intent(this, TelaRF33Solicitacoes::class.java)
            startActivity(intent)
        }

        // Ações simuladas
        btnAlugados?.setOnClickListener {
            Toast.makeText(this, "Abrir livros alugados", Toast.LENGTH_SHORT).show()
        }

        btnExcluirConta?.setOnClickListener {
            Toast.makeText(this, "Conta excluída (simulação)", Toast.LENGTH_SHORT).show()
        }

        // 👇 BARRA ADM
        NavigationUtils.setupAdminNavigation(this)
    }
}