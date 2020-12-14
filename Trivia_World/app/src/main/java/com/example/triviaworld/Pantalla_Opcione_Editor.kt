package com.example.triviaworld

import Adapters.AdapterPreguntas
import BBDD.BDPreguntasRespuestas
import Clases.Preguntas
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Pantalla_Opcione_Editor : AppCompatActivity() {

    val database: SQLiteDatabase by lazy{ BDPreguntasRespuestas(this).writableDatabase }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_opcione_editor)



        var datos:ArrayList<Preguntas> = ArrayList<Preguntas>()
        var respuestasC: String = ""

        var cursorP: Cursor =database.query(BDPreguntasRespuestas.tablaPreguntas,null,null,
                null,null,null,BDPreguntasRespuestas.idTablaPreguntas+" asc")
        cursorP.moveToFirst()
        while(!cursorP.isAfterLast){
            var imagenI: Int = cursorP.getInt(cursorP.getColumnIndex(BDPreguntasRespuestas.Imagen))
            var preguntasI: String =cursorP.getString(cursorP.getColumnIndex(BDPreguntasRespuestas.Pregunta))
            respuestasC=""

            for (i in 1..4){

                var idU: String = cursorP.getString(cursorP.getColumnIndex(BDPreguntasRespuestas.idTablaPreguntas)) + "0$i"
                var cursor2: Cursor =database.query(BDPreguntasRespuestas.tablaRespuestas,null,"id='$idU'",
                        null,null,null,BDPreguntasRespuestas.idTablaRespuestas+" asc")
                cursor2.moveToFirst()
                val respuesta:String=cursor2.getString(cursor2.getColumnIndex(BDPreguntasRespuestas.respuesta))
                respuestasC+= respuesta + "\n"

            }
            datos.add(Preguntas(imagenI, preguntasI, respuestasC))
            cursorP.moveToNext()
        }


        val contenedorRecycler: RecyclerView = findViewById<RecyclerView>(R.id.vistaRecycler)
        val adapter: AdapterPreguntas = AdapterPreguntas(this, datos)
        contenedorRecycler.adapter=adapter
        contenedorRecycler.layoutManager= LinearLayoutManager(this)



    }

    fun Aañadir(view: View) {

        val intent = Intent(this, Creador_Preguntas::class.java)
        startActivity(intent)

    }

    fun AaEditar(view: View) {

        val intent = Intent(this, Pantalla_Edita_Preguntas::class.java)
        startActivity(intent)

    }

    fun IraBorrar(view: View) {

        val intent = Intent(this, Pantalla_BorrarE::class.java)
        startActivity(intent)

    }

}