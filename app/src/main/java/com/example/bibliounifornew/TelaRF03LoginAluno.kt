package com.example.bibliounifornew 

class TelaRF03LoginAluno : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf03_loginaluno)

        // CAMPOS
        val email = findViewById<EditText>(R.id.editEmail)
        val senha = findViewById<EditText>(R.id.editSenha)

        // BOTÃO
        val botaoEntrar = findViewById<Button>(R.id.buttonEntrar)

        // TEXTOS
        val erro = findViewById<TextView>(R.id.textErroLogin)
        val criarConta = findViewById<TextView>(R.id.textCriarConta)
        val voltar = findViewById<TextView>(R.id.textVoltar)
        val esqueceuSenha = findViewById<TextView>(R.id.textEsqueceuSenha)

        // LOGIN
        botaoEntrar.setOnClickListener {

            val textoEmail = email.text.toString().trim()
            val textoSenha = senha.text.toString().trim()

            erro.visibility = View.GONE

            // Base de dados mockada
            val usuariosValidos = mapOf(
                "teste@email.com" to "12345678",
                "anderson.link.crush@hotmail.com" to "123456"
            )

            when {
                textoEmail.isEmpty() || textoSenha.isEmpty() -> {
                    erro.text = "Preencha todos os campos"
                    erro.visibility = View.VISIBLE
                }

                usuariosValidos[textoEmail] != textoSenha -> {
                    erro.text = "E-mail ou senha incorretos"
                    erro.visibility = View.VISIBLE
                }

                else -> {
                    Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, TelaRF09DashboardUsuario::class.java)
                    startActivity(intent)
                    finish() // Opcional: encerra a tela de login para não voltar a ela ao apertar 'back'
                }
            }
        }

        // CRIAR CONTA -> TelaRF05
        criarConta.setOnClickListener {
            val intent = Intent(this, TelaRF05CadastroNovoUsuario::class.java)
            startActivity(intent)
        }

        // ESQUECEU SENHA -> TelaRF06
        esqueceuSenha.setOnClickListener {
            val intent = Intent(this, TelaRF06RecuperacaoSenha::class.java)
            startActivity(intent)
        }

        // VOLTAR
        voltar.setOnClickListener {
            finish()
        }

        // UX MELHORADA (remove erro ao focar)
        email.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) erro.visibility = View.GONE
        }

        senha.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) erro.visibility = View.GONE
        }
    }
}