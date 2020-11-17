package com.example.triviaworld

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Pantalla_Redes: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.redes_sociales)
    }

    fun irEnlaceYoutube(view: View) {

        val abrirURL = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCck3TNv3wDRjeGxuN8gNtyQ"))
        startActivity(abrirURL)

    }

    fun volverInicio(view: View) {

    val intent = Intent(this, MainActivity::class.java)
    startActivity(intent)
    }

    fun irEnlaceInstagram(view: View) {

        val abrirURL = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/triviaworld_es/"))
        startActivity(abrirURL)

    }

    fun irEnlaceTwitter(view: View) {

        val abrirURL = Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/TriviaWorld_es\n"))
        startActivity(abrirURL)

    }
}