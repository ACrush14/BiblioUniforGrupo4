package com.example.bibliounifornew 

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.telarf01_bemvindo)

        val buttonComecar = findViewById<Button>(R.id.buttonComecar)
        buttonComecar.setOnClickListener {

            val usuarioLogado = false
            val tipoUsuario = listOf("adm", "user").random()

            if (!usuarioLogado) {
                startActivity(Intent(this, TelaRF02Intermediaria::class.java))

            } else {
                if (tipoUsuario == "adm") {
                    startActivity(Intent(this, TelaRF30DashboardADM::class.java))
                } else {
                    // Aqui deve-se garantir que TelaRF09DashboardUsuario também esteja no pacote correto
                    startActivity(Intent(this, TelaRF09DashboardUsuario::class.java))
                }
            }

            finish()
        }
    }
}