package com.example.bibliounifornew 

class TelaRF18 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TelaGestaoAmigosScreen()
        }
    }
}