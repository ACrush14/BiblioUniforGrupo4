package com.example.bibliounifornew 

class TelaRF335UsuarioNotificado : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.popup_rf33_5_usuario_notificado
        )

        // BOTÃO VOLTAR

        val btnVoltarPopup =
            findViewById<Button>(R.id.btnVoltarPopup)

        btnVoltarPopup.setOnClickListener {

            finish()
        }
    }
}