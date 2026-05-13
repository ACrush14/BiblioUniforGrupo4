package com.example.bibliounifornew 

class TelaRF05novousuario : AppCompatActivity() {

    lateinit var etNome: EditText
    lateinit var etUsuario: EditText
    lateinit var etEmail: EditText
    lateinit var etSenha: EditText
    lateinit var etConfirmaSenha: EditText
    lateinit var bntCriar: Button
    lateinit var bntEntreAqui: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.telarf04_cadastrar_novo_usuario)

        etNome = findViewById(R.id.editTextNome)
        etUsuario = findViewById(R.id.editTextUsuario)
        etSenha = findViewById(R.id.editTextTextSenha)
        etEmail = findViewById(R.id.editTextTextEmail)
        etConfirmaSenha = findViewById(R.id.editTextTextConfirmaSenha)
        bntEntreAqui = findViewById(R.id.EntreAqui)
        bntCriar = findViewById(R.id.Criar)

    }

    override fun onStart() {
        super.onStart()

    }

}