package com.example.bibliounifornew 

class TelaRF11RedefinirSenha : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf11_redefinirsenha)

        // CAMPOS
        val editNovaSenha = findViewById<EditText>(R.id.editNovaSenha)
        val editConfirmarSenha = findViewById<EditText>(R.id.editConfirmarSenha)
        val btnSalvar = findViewById<MaterialButton>(R.id.buttonSalvar)

        val erroSenha = findViewById<TextView>(R.id.textErroSenha)
        val erroConfirmar = findViewById<TextView>(R.id.textErroConfirmar)

        // BOTÃO FECHAR (X)
        val btnFechar = findViewById<TextView>(R.id.btnFechar)
        btnFechar.setOnClickListener {
            finish()
        }

        // 🔥 VALIDAÇÃO + SALVAR
        btnSalvar.setOnClickListener {

            val senha = editNovaSenha.text.toString()
            val confirmar = editConfirmarSenha.text.toString()

            erroSenha.visibility = View.GONE
            erroConfirmar.visibility = View.GONE

            var valido = true

            if (senha.length < 8) {
                erroSenha.visibility = View.VISIBLE
                erroSenha.text = "Mínimo 8 caracteres"
                valido = false
            }

            if (senha != confirmar) {
                erroConfirmar.visibility = View.VISIBLE
                erroConfirmar.text = "Senhas diferentes"
                valido = false
            }

            if (valido) {
                Toast.makeText(this, "Senha alterada!", Toast.LENGTH_SHORT).show()

                // VOLTA PRA RF10
                val intent = Intent(this, TelaRF10Configuracao::class.java)
                startActivity(intent)
                finish()
            }
        }

        // 🔥 BARRA DE TAREFAS

        val navHome = findViewById<ImageView>(R.id.navHome)
        val navCarrinho = findViewById<ImageView>(R.id.navCarrinho)
        val navBusca = findViewById<ImageView>(R.id.navBusca)
        val navFavoritos = findViewById<ImageView>(R.id.navFavoritos)
        val navLista = findViewById<ImageView>(R.id.navLista)
        val navUsuario = findViewById<ImageView>(R.id.navUsuario)

        navHome.setOnClickListener {
            startActivity(Intent(this, TelaRF09DashboardUsuario::class.java))
        }

        navCarrinho.setOnClickListener {
            startActivity(Intent(this, TelaRF19::class.java))
        }

        navBusca.setOnClickListener {
            startActivity(Intent(this, TelaRF12TelaDePesquisa::class.java))
        }

        navFavoritos.setOnClickListener {
            startActivity(Intent(this, TelaRF17ListaDesejosActivity::class.java))
        }

        navLista.setOnClickListener {
            startActivity(Intent(this, TelaRF16MinhaLivrariaActivity::class.java))
        }

        navUsuario.setOnClickListener {
            startActivity(Intent(this, TelaRF18::class.java))
        }
    }
}