package com.example.bibliounifornew 

class TelaRF23RenovacaoOnline : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf23_renovacao_online)

        val buttonConfirmarData = findViewById<Button>(R.id.btnConfirmarData)
        val buttonVoltar = findViewById<Button>(R.id.textVoltarDaRenovacao)

        // Ao confirmar, encerra esta atividade e volta para a tela anterior (TelaRF19)
        buttonConfirmarData.setOnClickListener {
            // Aqui você poderia adicionar a lógica de salvar a renovação
            finish()
        }

        // Ao clicar em voltar, apenas encerra a atividade atual
        buttonVoltar.setOnClickListener {
            finish()
        }
    }
}