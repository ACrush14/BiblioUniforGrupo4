package com.example.bibliounifornew 

class TelaRF30CrudADM : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf30_crud_adm)

        // Configuração da Navegação ADM (Barra inferior e topo)
        NavigationUtils.setupAdminNavigation(this)

        val btnCriarMidia = findViewById<MaterialButton>(R.id.btnCriarMidia)
        val btnVerificarMidia = findViewById<MaterialButton>(R.id.btnVerificarMidia)
        val btnGerenciarUsuario = findViewById<MaterialButton>(R.id.btnGerenciarUsuario)
        val btnApagarUsuario = findViewById<MaterialButton>(R.id.btnApagarUsuario)
        val btnApagarMidia = findViewById<MaterialButton>(R.id.btnApagarMidia)

        btnCriarMidia.setOnClickListener {
            val intent = Intent(this, TelaRF35CadastroDeLivros::class.java)
            startActivity(intent)
        }

        btnVerificarMidia.setOnClickListener {
            val intent = Intent(this, TelaRF42VerificarMidia::class.java)
            startActivity(intent)
        }

        btnGerenciarUsuario.setOnClickListener {
            val intent = Intent(this, TelaRF31GerenciamentoDeUsuarios::class.java)
            startActivity(intent)
        }

        btnApagarUsuario.setOnClickListener {
            showApagarUsuarioPopup()
        }

        btnApagarMidia.setOnClickListener {
            showApagarMidiaPopup()
        }
    }

    private fun showApagarUsuarioPopup() {
        AlertDialog.Builder(this)
            .setTitle("Apagar Usuário")
            .setMessage("Tem certeza que deseja apagar este usuário? Esta ação não pode ser desfeita.")
            .setPositiveButton("Apagar") { _, _ ->
                Toast.makeText(this, "Usuário apagado com sucesso!", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    private fun showApagarMidiaPopup() {
        AlertDialog.Builder(this)
            .setTitle("Apagar Mídia")
            .setMessage("Tem certeza que deseja apagar esta mídia do acervo?")
            .setPositiveButton("Apagar") { _, _ ->
                Toast.makeText(this, "Mídia apagada com sucesso!", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }
}