package com.example.triviaworld

import Adapters.AdapterOpciones
import Adapters.AdapterRespuestas
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Pantalla_Secundaria: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_secundaria)


        val datos: ArrayList<String> = ArrayList<String>()


       /* datos.set(0,"hola")
        datos.set(1,resources.getString(R.string.boton2))
        datos.set(2,resources.getString(R.string.boton3))
        datos.set(3,resources.getString(R.string.boton4))*/

        datos.add(resources.getString(R.string.boton1))
        datos.add(resources.getString(R.string.boton2))
        datos.add(resources.getString(R.string.boton3))
        datos.add(resources.getString(R.string.boton4))


        //Refenciamos al recyclerView
        val recyclerRespuestas: RecyclerView = findViewById<RecyclerView>(R.id.recyclerSecundaria)

        //Creamos el adapter
        val adapter: AdapterRespuestas = AdapterRespuestas(this,datos)

        //A nuestro recyclerView le metemos el adapter creado
        recyclerRespuestas.adapter=adapter

        //Establecemos el LayoutManager para que se ocupe de mostrar los datos de la lista
        recyclerRespuestas.layoutManager= LinearLayoutManager(this)
    }
}