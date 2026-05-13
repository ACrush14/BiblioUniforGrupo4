package com.example.bibliounifornew 

class TelaRF27RedefinirSenhaADM : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf27_redefinir_senha_adm)

        val edtNovaSenha = findViewById<EditText>(R.id.editTextTextPassword)
        val edtConfirmar = findViewById<EditText>(R.id.editTextTextPassword2)
        val txtErroSenhasDiferentes = findViewById<TextView>(R.id.textViewErro2)
        val btnRedefinir = findViewById<Button>(R.id.btnRedefinirSenha)
        val txtVoltar = findViewById<TextView>(R.id.textVoltar)

        btnRedefinir.setOnClickListener {
            val senha1 = edtNovaSenha.text.toString()
            val senha2 = edtConfirmar.text.toString()

            if (senha1.isEmpty() || senha2.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha as duas senhas.", Toast.LENGTH_SHORT).show()
            } else if (senha1 != senha2) {
                txtErroSenhasDiferentes.visibility = View.VISIBLE
            } else {
                txtErroSenhasDiferentes.visibility = View.INVISIBLE
                Toast.makeText(this, "Senha alterada com sucesso!", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        txtVoltar.setOnClickListener {
            finish()
        }
    }
}