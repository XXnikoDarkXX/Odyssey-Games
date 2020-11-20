package com.example.triviaworld

import Adapters.ListaPreguntas
import Clases.Preguntas
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView

class Editor_Preguntas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.editor__preguntas)

        var preguntas:ArrayList<Preguntas> = ArrayList<Preguntas>()
        preguntas.add(Preguntas(R.drawable.imagen_prueba,  resources.getString(R.string.pregunta1_historia) ,  resources.getString(R.string.respuesta1_historia)+"\n" +
                resources.getString(R.string.respuesta2_historia)+"\n" +resources.getString(R.string.respuesta3_historia)
                +"\n" +resources.getString(R.string.respuesta4_historia)))
        preguntas.add(Preguntas(R.drawable.intelestari,  resources.getString(R.string.pregunta1_entretenimiento) ,  resources.getString(R.string.respuesta1_entretenimiento)+
                "\n" +resources.getString(R.string.respuesta2_entretenimiento)+"\n" +resources.getString(R.string.respuesta3_entretenimiento)
                +"\n" +resources.getString(R.string.respuesta4_entretenimiento)))

        val adapter: ListaPreguntas = ListaPreguntas(this, preguntas)
        val lista: ListView = findViewById(R.id.espacioLista)
        //preguntas.get(0).imagen.l
        lista.adapter=adapter


    }

    fun Aañadir(view: View) {

        val intent = Intent(this, Creador_Preguntas::class.java)
        startActivity(intent)

    }

}