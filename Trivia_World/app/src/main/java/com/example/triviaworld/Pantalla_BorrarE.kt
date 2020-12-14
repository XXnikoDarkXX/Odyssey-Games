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
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Pantalla_BorrarE : AppCompatActivity() {

    val database: SQLiteDatabase by lazy{ BDPreguntasRespuestas(this).writableDatabase }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla__borrare)

        Refrescar()

    }

    fun Refrescar(){
        var datos:ArrayList<Preguntas> = ArrayList<Preguntas>()
        var tamano: Int = 1
        var respuestasC: String = ""

        var cursorP: Cursor =database.query(
            BDPreguntasRespuestas.tablaPreguntas,null,null,
            null,null,null, BDPreguntasRespuestas.idTablaPreguntas+" asc")
        cursorP.moveToFirst()
        while(!cursorP.isAfterLast){
            var imagenI: Int = cursorP.getInt(cursorP.getColumnIndex(BDPreguntasRespuestas.Imagen))
            var preguntasI: String =cursorP.getString(cursorP.getColumnIndex(BDPreguntasRespuestas.Pregunta))
            respuestasC=""

            for (i in 1..4){

                var idU: String = cursorP.getString(cursorP.getColumnIndex(BDPreguntasRespuestas.idTablaPreguntas)) + "0$i"
                var cursor2: Cursor =database.query(
                    BDPreguntasRespuestas.tablaRespuestas,null,"id='$idU'",
                    null,null,null, BDPreguntasRespuestas.idTablaRespuestas+" asc")
                cursor2.moveToFirst()
                val respuesta:String=cursor2.getString(cursor2.getColumnIndex(BDPreguntasRespuestas.respuesta))
                respuestasC+= respuesta + "\n"

            }
            datos.add(Preguntas(imagenI, preguntasI, respuestasC))
            tamano++
            cursorP.moveToNext()
        }

        var preguntasS:Array<String> = Array<String>(tamano){""}
        var cursor2: Cursor =database.query(
            BDPreguntasRespuestas.tablaPreguntas,null,null,
            null,null,null, BDPreguntasRespuestas.idTablaPreguntas+" asc")
        cursor2.moveToFirst()
        tamano=1
        while(!cursor2.isAfterLast){
            var imagenI: Int = cursor2.getInt(cursor2.getColumnIndex(BDPreguntasRespuestas.Imagen))
            var preguntasI: String =cursor2.getString(cursor2.getColumnIndex(BDPreguntasRespuestas.Pregunta))

            preguntasS.set(tamano, preguntasI)
            tamano++
            cursor2.moveToNext()
        }
        val spinner: Spinner = findViewById<Spinner>(R.id.spinner3)
        if (spinner != null) {
            val adapter1 = ArrayAdapter(this,android.R.layout.simple_spinner_item, preguntasS)
            spinner.adapter = adapter1
        }



        val contenedorRecycler: RecyclerView = findViewById<RecyclerView>(R.id.recyclerB)
        val adapter: AdapterPreguntas = AdapterPreguntas(this, datos)
        contenedorRecycler.adapter=adapter
        contenedorRecycler.layoutManager= LinearLayoutManager(this)
    }

    fun BorrarE(view: View) {

        val spinner: Spinner = findViewById<Spinner>(R.id.spinner3)
        var idE: String = spinner.selectedItemId.toString()
        val cant = database.delete(BDPreguntasRespuestas.tablaPreguntas, "id=${idE}", null)
        for (i in 1..4){
            var auxId: String = idE + "0$i"
            val cant = database.delete(BDPreguntasRespuestas.tablaRespuestas, "id=${auxId}", null)
        }
        Refrescar()

    }
}