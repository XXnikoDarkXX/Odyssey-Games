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

        val intent = Intent(this, Pantalla_Secundaria::class.java)
        var bundle:Bundle=Bundle()
        val seleccionado: ArrayList<String> = ArrayList<String>()
        seleccionado.add("Arte")
        bundle.putStringArrayList("tipo",seleccionado)
        intent.putExtras(bundle)
        startActivity(intent)

    }

    fun irAHistoria(view: View) {

        val intent = Intent(this, Pantalla_Secundaria::class.java)
        var bundle:Bundle=Bundle()
        val seleccionado: ArrayList<String> = ArrayList<String>()
        seleccionado.add("Historia")
        bundle.putStringArrayList("tipo",seleccionado)
        intent.putExtras(bundle)
        startActivity(intent)

    }

    fun irAEntretenimiento(view: View) {

        val intent = Intent(this, Pantalla_Secundaria::class.java)
        var bundle:Bundle=Bundle()
        val seleccionado: ArrayList<String> = ArrayList<String>()
        seleccionado.add("Entretenimiento")
        bundle.putStringArrayList("tipo",seleccionado)
        intent.putExtras(bundle)
        startActivity(intent)

    }

    fun irACiencia(view: View) {

        val intent = Intent(this, Pantalla_Secundaria::class.java)
        var bundle:Bundle=Bundle()
        val seleccionado: ArrayList<String> = ArrayList<String>()
        seleccionado.add("Ciencia")
        bundle.putStringArrayList("tipo",seleccionado)
        intent.putExtras(bundle)
        startActivity(intent)

    }

    fun irAGeografia(view: View) {

        val intent = Intent(this, Pantalla_Secundaria::class.java)
        var bundle:Bundle=Bundle()
        val seleccionado: ArrayList<String> = ArrayList<String>()
        seleccionado.add("Geografía")
        bundle.putStringArrayList("tipo",seleccionado)
        intent.putExtras(bundle)
        startActivity(intent)

    }

}