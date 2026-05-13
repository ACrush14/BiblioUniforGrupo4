package com.example.bibliounifornew 

class TelaRF25 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ForgotPasswordScreen(
                onNavigateBack = { finish() },
                onNavigateToValidation = {
                    // Aqui iria para a tela de validação (RF26)
                    // Por enquanto, apenas fecha ou navega conforme o fluxo
                    finish()
                }
            )
        }
    }
}