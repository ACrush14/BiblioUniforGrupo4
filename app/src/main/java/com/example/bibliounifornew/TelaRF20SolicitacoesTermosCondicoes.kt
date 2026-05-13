package com.example.bibliounifornew 

class TelaRF20SolicitacoesTermosCondicoes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf20_solicitacoes_termos_condicoes)

        val checkBox = findViewById<CheckBox>(R.id.checkSolicitacoes)
        val buttonContinuar = findViewById<Button>(R.id.btnContinuarSolicitacoes)

        buttonContinuar.setOnClickListener {
            if (checkBox.isChecked) {
                // Caminho: Termos -> Voltar Biblioteca
                val intent = Intent(this, TelaRF20SolicitacoesVoltarBiblioteca::class.java)
                startActivity(intent)
            } else {
                // Aviso caso não marque a caixa
                Toast.makeText(this, "Por favor, aceite os termos para continuar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}