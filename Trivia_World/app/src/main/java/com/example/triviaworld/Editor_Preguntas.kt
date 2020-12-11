package com.example.triviaworld

import Adapters.AdapterPreguntas
import Clases.Preguntas
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Editor_Preguntas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.editor__preguntas)

        var preguntas:ArrayList<Preguntas> = ArrayList<Preguntas>()
        preguntas.add(Preguntas(R.drawable.imagen_prueba,  resources.getString(R.string.pregunta1_historia) ,  resources.getString(R.string.respuesta1_historia)+"\n" +
                resources.getString(R.string.respuesta2_historia)+"\n" +resources.getString(R.string.respuesta3_historia)
                +"\n" +resources.getString(R.string.respuesta4_historia)))
        preguntas.add(Preguntas(R.drawable.imagen1_entretenimiento,  resources.getString(R.string.pregunta1_entretenimiento) ,  resources.getString(R.string.respuesta1_entretenimiento)+
                "\n" +resources.getString(R.string.respuesta2_entretenimiento)+"\n" +resources.getString(R.string.respuesta3_entretenimiento)
                +"\n" +resources.getString(R.string.respuesta4_entretenimiento)))
        preguntas.add(Preguntas(R.drawable.imagen1_geografia,  resources.getString(R.string.pregunta1_geografia) ,  resources.getString(R.string.respuesta1_geografia)+
                "\n" +resources.getString(R.string.respuesta2_geografia)+"\n" +resources.getString(R.string.respuesta3_geografia)
                +"\n" +resources.getString(R.string.respuesta4_geografia)))
        preguntas.add(Preguntas(R.drawable.imagen1_ciencias,  resources.getString(R.string.pregunta1_ciencias) ,  resources.getString(R.string.respuesta1_ciencias)+
                "\n" +resources.getString(R.string.respuesta2_ciencias)+"\n" +resources.getString(R.string.respuesta3_ciencias)
                +"\n" +resources.getString(R.string.respuesta4_ciencias)))

        val contenedorRecycler: RecyclerView = findViewById<RecyclerView>(R.id.vistaRecycler)
        val adapter: AdapterPreguntas = AdapterPreguntas(this, preguntas)
        contenedorRecycler.adapter=adapter
        contenedorRecycler.layoutManager= LinearLayoutManager(this)


    }

    fun Aañadir(view: View) {

        val intent = Intent(this, Creador_Preguntas::class.java)
        startActivity(intent)

    }

}