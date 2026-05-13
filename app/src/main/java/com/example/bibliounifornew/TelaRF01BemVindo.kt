package com.example.bibliounifornew

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.bibliounifor.R

class TelaRF01BemVindo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf01_bemvindo)

        val botaoComecar = findViewById<Button>(R.id.buttonComecar)

        botaoComecar.setOnClickListener {
            val intent = Intent(this, TelaRF02Intermediaria::class.java)
            startActivity(intent)

            //dont die
        }
    }
}