package com.example.triviaworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Pantalla_eleccionJuego : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_eleccion_juego)
    }

    fun irAArte(view: View) {

        setContentView(R.layout.pantalla_secundaria)

    }

    fun irAHistoria(view: View) {

        setContentView(R.layout.pantalla_secundaria)

    }

    fun irAEntretenimiento(view: View) {

        setContentView(R.layout.pantalla_secundaria)

    }

    fun irACiencia(view: View) {

        setContentView(R.layout.pantalla_secundaria)

    }

    fun irAGeografia(view: View) {

        setContentView(R.layout.pantalla_secundaria)

    }

}