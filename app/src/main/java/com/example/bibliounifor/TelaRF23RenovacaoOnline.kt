package com.example.bibliounifor

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TelaRF23RenovacaoOnline : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf23_renovacao_online)

        val buttonConfirmarData = findViewById<Button>(R.id.btnConfirmarData)

        // Ao confirmar, encerra esta atividade e volta para a tela anterior (TelaRF19)
        buttonConfirmarData.setOnClickListener {
            // Aqui você poderia adicionar a lógica de salvar a renovação
            finish()
        }
    }
}
