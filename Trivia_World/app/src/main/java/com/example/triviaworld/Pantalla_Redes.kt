package com.example.triviaworld

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Pantalla_Redes: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.redes_sociales)
    }

    fun irEnlace(view: View) {

        val abrirURL = Intent(Intent.ACTION_VIEW, Uri.parse("http://google.es"))
        startActivity(abrirURL)

    }

    fun volverInicio(view: View) {

    val intent = Intent(this, MainActivity::class.java)
    startActivity(intent)
    }
}