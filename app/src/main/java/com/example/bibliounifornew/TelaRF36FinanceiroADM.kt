package com.example.bibliounifornew 

class TelaRF36FinanceiroADM : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Mantive o nome do layout exatamente como você enviou
        setContentView(R.layout.telarf36_finaceiro_adm)

        // 👇 BARRA ADM
        NavigationUtils.setupAdminNavigation(this)
    }
}