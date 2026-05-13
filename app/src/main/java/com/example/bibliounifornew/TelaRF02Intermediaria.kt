package com.example.bibliounifornew 

class TelaRF02Intermediaria : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf02_intermediaria)

        val botaoEstudante = findViewById<MaterialButton>(R.id.btnEstudante)
        val botaoAdmin = findViewById<MaterialButton>(R.id.btnAdmin)

        botaoEstudante.setOnClickListener {
            val intent = Intent(this, TelaRF03LoginAluno::class.java)
            val options = ActivityOptions.makeCustomAnimation(this, android.R.anim.fade_in, android.R.anim.fade_out)
            startActivity(intent, options.toBundle())
        }

        botaoAdmin.setOnClickListener {
            val intent = Intent(this, TelaRF24::class.java)
            val options = ActivityOptions.makeCustomAnimation(this, android.R.anim.fade_in, android.R.anim.fade_out)
            startActivity(intent, options.toBundle())
        }
    }
}