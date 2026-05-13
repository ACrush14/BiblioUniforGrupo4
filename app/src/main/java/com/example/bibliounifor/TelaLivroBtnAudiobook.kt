package com.example.bibliounifor

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bibliounifornew.R

class TelaLivroBtnAudiobook : AppCompatActivity() {

    private val audioUrl = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telarf12_livro_btn_audiobook)

        val btnSpotify = findViewById<Button>(R.id.buttonSpotify)
        val btnMusicPlayer = findViewById<Button>(R.id.buttonMusicPlayer)
        val btnOuvirAgora = findViewById<Button>(R.id.buttonOuvirAgora)

        // 1. ABRIR SPOTIFY REAL
        btnSpotify.setOnClickListener {
            abrirSpotify()
        }

        // 2. ABRIR PLAYER DE MÚSICA REAL (Chooser)
        btnMusicPlayer.setOnClickListener {
            abrirPlayerMusicaComChooser()
        }

        // 3. OUVIR AGORA (Direto no app padrão)
        btnOuvirAgora.setOnClickListener {
            abrirAudioDireto()
        }
    }

    private fun abrirSpotify() {
        val packageName = "com.spotify.music"
        val intent = packageManager.getLaunchIntentForPackage(packageName)
        
        if (intent != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "Spotify não encontrado. Abrindo na Play Store...", Toast.LENGTH_SHORT).show()
            try {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName")))
            } catch (e: Exception) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$packageName")))
            }
        }
    }

    private fun abrirPlayerMusicaComChooser() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setDataAndType(Uri.parse(audioUrl), "audio/*")
        
        val chooser = Intent.createChooser(intent, "Escolha um player de áudio...")
        
        try {
            startActivity(chooser)
        } catch (e: Exception) {
            Toast.makeText(this, "Nenhum aplicativo de música compatível encontrado.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun abrirAudioDireto() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setDataAndType(Uri.parse(audioUrl), "audio/*")
        
        try {
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(this, "Erro ao abrir o player padrão.", Toast.LENGTH_SHORT).show()
        }
    }
}
