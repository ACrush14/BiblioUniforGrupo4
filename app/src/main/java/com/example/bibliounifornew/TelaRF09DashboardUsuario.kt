package com.example.bibliounifornew 

class TelaRF09DashboardUsuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf09_dashboardusuario)

        // Botões do Header
        val btnConfig = findViewById<ImageView>(R.id.btnConfig)
        val btnNotificacao = findViewById<ImageView>(R.id.btnNotificacao)
        val profileImage = findViewById<ImageView>(R.id.profile_image)
        val textNomeUsuario = findViewById<TextView>(R.id.textNomeUsuario)

        // Botões de Ações Rápidas (Cards/Buttons no ScrollView)
        val btnProcurarLivros = findViewById<MaterialButton>(R.id.btnProcurarLivros)
        val btnMinhaLivraria = findViewById<MaterialButton>(R.id.btnMinhaLivrariaDash)
        val btnListaDesejo = findViewById<MaterialButton>(R.id.btnListaDesejoDash)
        val btnAmigos = findViewById<MaterialButton>(R.id.btnAmigosDash)
        val btnHistorico = findViewById<MaterialButton>(R.id.btnHistoricoDash)
        val btnStatusAluguel = findViewById<MaterialButton>(R.id.btnStatusAluguelDash)
        val btnSair = findViewById<MaterialButton>(R.id.btnSairDash)

        // Navegação via Engrenagem -> Configuração (RF10)
        btnConfig.setOnClickListener {
            startActivity(Intent(this, TelaRF10Configuracao::class.java))
        }

        btnNotificacao.setOnClickListener {
            startActivity(Intent(this, TelaRF21Notificacoes::class.java))
        }

        // Ações Rápidas
        btnProcurarLivros.setOnClickListener {
            startActivity(Intent(this, TelaRF12TelaDePesquisa::class.java))
        }

        btnMinhaLivraria.setOnClickListener {
            startActivity(Intent(this, TelaRF16MinhaLivrariaActivity::class.java))
        }

        btnListaDesejo.setOnClickListener {
            startActivity(Intent(this, TelaRF17ListaDesejosActivity::class.java))
        }

        btnAmigos.setOnClickListener {
            startActivity(Intent(this, TelaRF18::class.java))
        }

        btnHistorico.setOnClickListener {
            startActivity(Intent(this, TelaRF22Historico::class.java))
        }

        btnStatusAluguel.setOnClickListener {
            startActivity(Intent(this, TelaRF19::class.java))
        }

        btnSair.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        // 🔥 BARRA DE TAREFAS (BOTTOM NAV - 6 ITENS)
        val navHome = findViewById<ImageView>(R.id.navHome)
        val navCarrinho = findViewById<ImageView>(R.id.navCarrinho)
        val navBusca = findViewById<ImageView>(R.id.navBusca)
        val navFavoritos = findViewById<ImageView>(R.id.navFavoritos)
        val navLista = findViewById<ImageView>(R.id.navLista)
        val navUsuario = findViewById<ImageView>(R.id.navUsuario)

        navHome.setOnClickListener {
            // Já estamos na Home
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