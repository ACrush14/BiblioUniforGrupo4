package com.example.bibliounifornew 

class TelaRF37ConfirmarCadastroADM : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf37_confirmar_cadastro_adm)

        // 👇 BARRA ADM
        NavigationUtils.setupAdminNavigation(this)
    }
}