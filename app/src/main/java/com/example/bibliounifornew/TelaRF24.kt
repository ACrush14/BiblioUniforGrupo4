package com.example.bibliounifornew 

class TelaRF24 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen(
                onNavigateToForgot = {
                    val intent = Intent(this, TelaRF25::class.java)
                    startActivity(intent)
                },
                onNavigateToRegister = {
                    val intent = Intent(this, TelaRF28NovaContaADM::class.java)
                    startActivity(intent)
                },
                onLoginSuccess = {
                    val intent = Intent(this, TelaRF30DashboardADM::class.java)
                    startActivity(intent)
                    finish()
                },
                onNavigateBack = {
                    finish() // Fecha a tela de login e volta para a anterior
                }
            )
        }
    }
}