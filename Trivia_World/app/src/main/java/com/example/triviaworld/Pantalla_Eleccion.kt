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


        val intent = Intent(this, Pantalla_eleccionJuego::class.java)

        startActivity(intent)

    }

    fun irRandom(view: View) {

        val intent = Intent(this, Pantalla_Secundaria::class.java)
        startActivity(intent)

    }

    fun irEdit(view: View) {

        val intent = Intent(this, Pantalla_Opcione_Editor::class.java)
        startActivity(intent)

    }
}