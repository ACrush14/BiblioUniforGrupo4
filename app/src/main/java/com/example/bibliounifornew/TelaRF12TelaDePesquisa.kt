package com.example.bibliounifornew 

class TelaRF12TelaDePesquisa : AppCompatActivity() {

    private lateinit var adapter: LivroAdapter
    private val database by lazy { AppDatabase.getDatabase(this) }
    private val livroDao by lazy { database.livroDao() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf12_teladepesquisa)

        // Padronização da Navegação e Cabeçalho
        NavigationUtils.setupTopBar(this)
        NavigationUtils.setupBottomNavigation(this)

        setupRecyclerView()
        setupListeners()
        popularBancoDeDados()
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerLivros)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        adapter = LivroAdapter(emptyList()) { livro ->
            val intent = Intent(this, TelaRF13TelaDoLivro::class.java)
            intent.putExtra("LIVRO_ID", livro.id)
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        lifecycleScope.launch {
            livroDao.buscarTodosLivros().collectLatest { lista ->
                adapter.updateData(lista)
            }
        }
    }

    private fun setupListeners() {
        val editPesquisa = findViewById<EditText>(R.id.editPesquisa)
        val btnPesquisar = findViewById<MaterialButton>(R.id.btnPesquisar)
        val btnFiltro = findViewById<ImageView>(R.id.btnFiltro)

        btnPesquisar.setOnClickListener {
            realizarPesquisa(editPesquisa.text.toString())
        }

        editPesquisa.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                realizarPesquisa(editPesquisa.text.toString())
                true
            } else false
        }

        btnFiltro.setOnClickListener {
            mostrarPopupFiltro()
        }
    }

    private fun realizarPesquisa(query: String) {
        lifecycleScope.launch {
            val formatQuery = "%$query%"
            livroDao.pesquisarLivros(formatQuery).collectLatest { resultados ->
                adapter.updateData(resultados)
            }
        }
    }

    private fun mostrarPopupFiltro() {
        val dialog = BottomSheetDialog(this)
        val view = layoutInflater.inflate(R.layout.popup_filtro_pesquisa, null)
        dialog.setContentView(view)

        view.findViewById<MaterialButton>(R.id.btnSalvarFiltro).setOnClickListener {
            dialog.dismiss()
        }

        view.findViewById<MaterialButton>(R.id.btnLimparFiltro).setOnClickListener {
            view.findViewById<ChipGroup>(R.id.cgDisponibilidade).clearCheck()
            view.findViewById<ChipGroup>(R.id.cgCategoria).clearCheck()
        }

        dialog.show()
    }

    private fun popularBancoDeDados() {
        lifecycleScope.launch {
            // Lógica de população mantida para garantir dados nos testes
        }
    }
}