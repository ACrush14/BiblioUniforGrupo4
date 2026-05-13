package com.example.bibliounifornew 

class TelaRF28NovaContaADM : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf28_nova_conta_adm)

        val edtNomeCompleto = findViewById<EditText>(R.id.edtNomeCompleto)
        val edtNomeUsuario = findViewById<EditText>(R.id.edtNomeUsuario)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtCredencial = findViewById<EditText>(R.id.edtCredencial)
        val edtSenha = findViewById<EditText>(R.id.edtSenha)
        val edtConfirmaSenha = findViewById<EditText>(R.id.edtConfirmaSenha)

        val txtErroEmail = findViewById<TextView>(R.id.txtErroEmail)
        val txtErroCredencial = findViewById<TextView>(R.id.txtErroCredencial)
        val txtErroSenha = findViewById<TextView>(R.id.txtErroSenha)

        val btnCriar = findViewById<Button>(R.id.btnCriar)
        val txtEntreAqui = findViewById<TextView>(R.id.txtEntreAqui)

        btnCriar.setOnClickListener {
            txtErroEmail.visibility = View.GONE
            txtErroCredencial.visibility = View.GONE
            txtErroSenha.visibility = View.GONE

            val email = edtEmail.text.toString().trim()
            val credencial = edtCredencial.text.toString().trim()
            val senha1 = edtSenha.text.toString()
            val senha2 = edtConfirmaSenha.text.toString()

            var temErro = false

            if (email.isEmpty() || !email.contains("@")) {
                txtErroEmail.visibility = View.VISIBLE
                temErro = true
            }

            if (credencial.isEmpty()) {
                txtErroCredencial.visibility = View.VISIBLE
                temErro = true
            }

            val temMaiuscula = senha1.any { it.isUpperCase() }
            val temNumero = senha1.any { it.isDigit() }
            val temTamanho = senha1.length >= 8

            if (!temTamanho || !temNumero || !temMaiuscula || senha1 != senha2) {
                txtErroSenha.visibility = View.VISIBLE
                temErro = true
            }

            if (!temErro) {
                mostrarPopUpSucesso()
            }
        }

        txtEntreAqui.setOnClickListener {
            finish()
        }
    }

    private fun mostrarPopUpSucesso() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Sucesso!")
        builder.setMessage("Sua conta ADM foi criada com sucesso.")
        builder.setCancelable(false)
        builder.setPositiveButton("Retornar ao Login") { dialog, _ ->
            dialog.dismiss()
            finish()
        }
        builder.show()
    }
}