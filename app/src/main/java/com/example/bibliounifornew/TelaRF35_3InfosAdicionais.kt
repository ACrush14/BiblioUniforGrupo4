package com.example.bibliounifornew 

class TelaRF35_3InfosAdicionais : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf35_3_infos_adicionais)

        val btnIrVersoes = findViewById<MaterialButton>(R.id.btnIrVersoes)

        btnIrVersoes.setOnClickListener {
            val intent = Intent(this, TelaRF35_4Versoes::class.java)
            startActivity(intent)
        }

        // 👇 BARRA ADM
        NavigationUtils.setupAdminNavigation(this)
    }
}