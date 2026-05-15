package com.example.bibliounifornew

import com.example.bibliounifornew.login.TelaRF02Intermediaria

class TelaRF40ConfigADM : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf40_config_adm)

        // 👇 Padronização da Navegação ADM
        NavigationUtils.setupAdminNavigation(this)

        // Botões específicos da tela de configuração
        val btnVoltarDashboard = findViewById<MaterialButton>(R.id.btnVoltarDashboard)
        val btnVoltar = findViewById<MaterialButton>(R.id.btnVoltar)
        val btnRedefinirSenha = findViewById<MaterialButton>(R.id.btnRedefinirSenha)
        val btnApagarConta = findViewById<MaterialButton>(R.id.btnApagarConta)

        btnVoltarDashboard?.setOnClickListener {
            val intent = Intent(this, TelaRF30DashboardADM::class.java)
            startActivity(intent)
        }

        btnVoltar?.setOnClickListener {
            finish() // Fecha a tela atual e volta para a anterior
        }

        btnRedefinirSenha?.setOnClickListener {
            val intent = Intent(this, TelaRF41RedefinirADMInterno::class.java)
            startActivity(intent)
        }

        btnApagarConta?.setOnClickListener {
            // Lógica para apagar conta ou logout
            val intent = Intent(this, TelaRF02Intermediaria::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}