package com.example.bibliounifornew 

class TelaRF15LeituraActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val livroId = intent.getIntExtra("LIVRO_ID", 1)

        setContent {
            TelaLeituraScreen(
                livroId = livroId,
                onBack = { finish() }
            )
        }
    }
}