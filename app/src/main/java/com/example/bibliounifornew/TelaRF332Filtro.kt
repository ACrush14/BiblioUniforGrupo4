package com.example.bibliounifornew 

class TelaRF332Filtro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.popup_filtro_verificar_midia)

        // BOTÕES

        val btnSalvarFiltro =
            findViewById<Button>(R.id.btnSalvarFiltro)

        val btnLimparFiltro =
            findViewById<Button>(R.id.btnLimparFiltro)

        val btnPdf =
            findViewById<Button>(R.id.btnPdf)

        val btnAudioBook =
            findViewById<Button>(R.id.btnAudioBook)

        val btnBraille =
            findViewById<Button>(R.id.btnBraille)

        val btnAluguel =
            findViewById<Button>(R.id.btnAluguel)

        // FECHAR POPUP

        btnSalvarFiltro.setOnClickListener {
            finish()
        }

        btnLimparFiltro.setOnClickListener {
            finish()
        }

        btnPdf.setOnClickListener {
            finish()
        }

        btnAudioBook.setOnClickListener {
            finish()
        }

        btnBraille.setOnClickListener {
            finish()
        }

        btnAluguel.setOnClickListener {
            finish()
        }
    }
}