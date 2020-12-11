package com.example.triviaworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Pantalla_eleccionJuego : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_eleccion_juego)
    }

    fun irAArte(view: View) {

        //var aux: String = "Arte"
        //val trundle: bundle
        val intent = Intent(this, Pantalla_Secundaria::class.java)
        startActivity(intent)

    }

    fun irAHistoria(view: View) {

        //var aux: String = "Historia"
        //val trundle: bundle
        val intent = Intent(this, Pantalla_Secundaria::class.java)
        startActivity(intent)

    }

    fun irAEntretenimiento(view: View) {

        //var aux: String = "Entretenimiento"
        //val trundle: bundle
        val intent = Intent(this, Pantalla_Secundaria::class.java)
        startActivity(intent)

    }

    fun irACiencia(view: View) {

        //var aux: String = "Ciencia"
        //val trundle: bundle
        val intent = Intent(this, Pantalla_Secundaria::class.java)
        startActivity(intent)

    }

    fun irAGeografia(view: View) {

        //var aux: String = "Geografia"
        //val trundle: bundle
        val intent = Intent(this, Pantalla_Secundaria::class.java)
        startActivity(intent)

    }

}