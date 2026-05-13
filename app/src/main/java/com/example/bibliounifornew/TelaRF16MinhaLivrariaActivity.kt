package com.example.bibliounifornew 

class TelaRF16MinhaLivrariaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TelaMinhaLivrariaScreen()
        }
    }
}