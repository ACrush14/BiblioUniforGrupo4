package com.example.bibliounifornew 

class TelaRF336BrailleConcluido : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.popup_rf33_6_braille_concluido
        )

        // BOTÃO VOLTAR

        val btnVoltarBraille =
            findViewById<Button>(R.id.btnVoltarBraille)

        btnVoltarBraille.setOnClickListener {

            finish()
        }
    }
}