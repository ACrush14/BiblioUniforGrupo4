package com.example.bibliounifornew 

class TelaRF35_1Data : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf35_1_data)

        val datePicker = findViewById<DatePicker>(R.id.datePicker)
        val btnConfirmarData = findViewById<MaterialButton>(R.id.btnConfirmarData)
        val btnVoltarData = findViewById<TextView>(R.id.btnVoltarData)

        btnConfirmarData.setOnClickListener {
            val dia = datePicker.dayOfMonth
            val mes = datePicker.month + 1 // Janeiro é 0
            val ano = datePicker.year

            // Formata a data dd/MM/yyyy
            val dataFormatada = String.format("%02d/%02d/%04d", dia, mes, ano)

            val intent = Intent()
            intent.putExtra("dataSelecionada", dataFormatada)
            setResult(RESULT_OK, intent)
            finish()
        }

        btnVoltarData.setOnClickListener {
            finish()
        }
    }
}