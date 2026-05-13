package com.example.bibliounifornew 

class TelaRF10Configuracao : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf10_configuracao)

        val btnRedefinir = findViewById<MaterialButton>(R.id.btnRedefinirSenha)
        val btnVoltar = findViewById<MaterialButton>(R.id.btnVoltarTelaInicial)
        val btnApagar = findViewById<MaterialButton>(R.id.btnApagarConta)

        btnRedefinir.setOnClickListener {
            val intent = Intent(this, TelaRF11RedefinirSenha::class.java)
            startActivity(intent)
        }

        btnVoltar.setOnClickListener {
            finish()
        }

        btnApagar.setOnClickListener {
            abrirPopupApagarConta()
        }

        // LÓGICA PARA EDITAR USUÁRIO
        val btnEditarUsuario = findViewById<ImageView>(R.id.btnEditarUsuario)
        val textUsuario = findViewById<TextView>(R.id.textUsuario)

        btnEditarUsuario.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Editar Usuário")

            // Criar um EditText dinamicamente para o popup
            val input = EditText(this)
            input.hint = "Digite o novo nome ou email"
            input.setText(textUsuario.text)
            builder.setView(input)

            builder.setPositiveButton("Salvar") { dialog, _ ->
                val novoNome = input.text.toString().trim()
                if (novoNome.isNotEmpty()) {
                    textUsuario.text = novoNome
                }
                dialog.dismiss()
            }

            builder.setNegativeButton("Cancelar") { dialog, _ ->
                dialog.cancel()
            }

            builder.show()
        }

        // 🔥 BARRA DE TAREFAS (BOTTOM NAV)
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

    private fun abrirPopupApagarConta() {
        val viewPopup = layoutInflater.inflate(R.layout.telarf10_10_apagar_conta, null)

        val editSenha = viewPopup.findViewById<EditText>(R.id.editSenhaPopup)
        val textErro = viewPopup.findViewById<TextView>(R.id.textErroPopup)
        val iconOlho = viewPopup.findViewById<ImageView>(R.id.iconOlho)
        val btnVoltarPopup = viewPopup.findViewById<Button>(R.id.btnVoltarPopup)
        val btnConfirmarPopup = viewPopup.findViewById<Button>(R.id.btnConfirmarPopup)

        val dialog = AlertDialog.Builder(this)
            .setView(viewPopup)
            .setCancelable(false)
            .create()

        dialog.show()

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        btnVoltarPopup.setOnClickListener {
            dialog.dismiss()
        }

        btnConfirmarPopup.setOnClickListener {
            val senha = editSenha.text.toString().trim()

            if (senha.isEmpty()) {
                textErro.visibility = View.VISIBLE
            } else {
                textErro.visibility = View.GONE

                // Aqui futuramente entra a lógica real para apagar a conta.
                dialog.dismiss()
            }
        }

        var senhaVisivel = false

        iconOlho.setOnClickListener {
            senhaVisivel = !senhaVisivel

            if (senhaVisivel) {
                editSenha.inputType = InputType.TYPE_CLASS_TEXT or
                        InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            } else {
                editSenha.inputType = InputType.TYPE_CLASS_TEXT or
                        InputType.TYPE_TEXT_VARIATION_PASSWORD
            }

            editSenha.setSelection(editSenha.text.length)
        }

        editSenha.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                textErro.visibility = View.GONE
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }
}