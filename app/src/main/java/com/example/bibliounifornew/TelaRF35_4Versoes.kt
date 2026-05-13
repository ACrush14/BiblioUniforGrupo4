package com.example.bibliounifornew 

class TelaRF35_4Versoes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf35_4_versoes)

        val btnSalvarLivro = findViewById<MaterialButton>(R.id.btnSalvarLivro)

        btnSalvarLivro.setOnClickListener {
            exibirPopupSucesso()
        }

        // 👇 BARRA ADM
        NavigationUtils.setupAdminNavigation(this)
    }

    private fun exibirPopupSucesso() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.telarf35_6_popup_sucesso, null)
        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(false)

        val dialog = builder.create()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        val btnVoltarPopup = dialogView.findViewById<MaterialButton>(R.id.btnVoltarPopup)
        btnVoltarPopup.setOnClickListener {
            dialog.dismiss()
            val intent = Intent(this, TelaRF30DashboardADM::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }

        dialog.show()
    }
}