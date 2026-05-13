package com.example.bibliounifor

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bibliounifornew.R

class TelaLivroBtnPdf : AppCompatActivity() {

    private val pdfUrl = "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf12_livro_btn_pdf)

        val btnGoogleDrive = findViewById<Button>(R.id.buttonGoogleDrive)
        val btnLeitorPdf = findViewById<Button>(R.id.buttonLeitorPdf)
        val btnBaixarPdf = findViewById<Button>(R.id.buttonBaixarPdf)

        // 1. ABRIR COM GOOGLE DRIVE (Tenta forçar se possível)
        btnGoogleDrive.setOnClickListener {
            abrirPdfNoDrive()
        }

        // 2. ABRIR COM QUALQUER LEITOR PDF (Chooser nativo)
        btnLeitorPdf.setOnClickListener {
            abrirPdfComChooser()
        }

        // 3. BAIXAR/ABRIR NO NAVEGADOR
        btnBaixarPdf.setOnClickListener {
            Toast.makeText(this, "Iniciando visualização no navegador...", Toast.LENGTH_SHORT).show()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(pdfUrl))
            startActivity(intent)
        }
    }

    private fun abrirPdfNoDrive() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setDataAndType(Uri.parse(pdfUrl), "application/pdf")
        intent.setPackage("com.google.android.apps.docs")
        
        try {
            startActivity(intent)
        } catch (e: Exception) {
            // Se não tiver Drive, usa o chooser normal
            Toast.makeText(this, "Google Drive não encontrado. Abrindo seletor...", Toast.LENGTH_SHORT).show()
            abrirPdfComChooser()
        }
    }

    private fun abrirPdfComChooser() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setDataAndType(Uri.parse(pdfUrl), "application/pdf")
        intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY or Intent.FLAG_GRANT_READ_URI_PERMISSION

        val chooser = Intent.createChooser(intent, "Abrir PDF com...")
        
        try {
            startActivity(chooser)
        } catch (e: Exception) {
            Toast.makeText(this, "Nenhum aplicativo de PDF encontrado.", Toast.LENGTH_LONG).show()
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(pdfUrl))
            startActivity(browserIntent)
        }
    }
}
