package com.example.bibliounifornew 

class TelaRF17ListaDesejosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TelaListaDesejosScreen()
        }
    }
}