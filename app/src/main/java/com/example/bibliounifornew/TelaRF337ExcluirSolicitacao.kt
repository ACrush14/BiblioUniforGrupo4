package com.example.bibliounifornew 

class TelaRF337ExcluirSolicitacao : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.popup_rf33_7_excluir_solicitacao
        )

        // BOTÕES

        val btnCancelarExcluir =
            findViewById<Button>(R.id.btnCancelarExcluir)

        val btnConfirmarExcluir =
            findViewById<Button>(R.id.btnConfirmarExcluir)

        // CANCELAR

        btnCancelarExcluir.setOnClickListener {

            finish()
        }

        // EXCLUIR

        btnConfirmarExcluir.setOnClickListener {

            finish()
        }
    }
}