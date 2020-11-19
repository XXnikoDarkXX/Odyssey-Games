package com.example.triviaworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Pantalla_Eleccion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla__eleccion)
    }


    fun irNormalM(view: View) {

        setContentView(R.layout.pantalla_secundaria)

    }

    /*fun botonRandomm(view: View) {

        val intent = Intent(this, Pantalla_Redes::class.java)
        startActivity(intent)

    }

    fun botonEditp(view: View) {

        val intent = Intent(this, Pantalla_Redes::class.java)
        startActivity(intent)

    }*/
}