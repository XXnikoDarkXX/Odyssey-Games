package com.example.triviaworld

import Adapters.AdapterPreguntas
import BBDD.BDPreguntasRespuestas
import Clases.Preguntas
import android.content.ContentValues
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Pantalla_Edita_Preguntas : AppCompatActivity() {

    val database: SQLiteDatabase by lazy{ BDPreguntasRespuestas(this).writableDatabase }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla__edita__preguntas)

        Refrescar()

    }

    fun Refrescar(){
        var datos:ArrayList<Preguntas> = ArrayList<Preguntas>()
        var tamano: Int = 1
        var respuestasC: String = ""

        var cursorP: Cursor =database.query(BDPreguntasRespuestas.tablaPreguntas,null,null,
                null,null,null, BDPreguntasRespuestas.idTablaPreguntas+" asc")
        cursorP.moveToFirst()
        while(!cursorP.isAfterLast){
            var imagenI: Int = cursorP.getInt(cursorP.getColumnIndex(BDPreguntasRespuestas.Imagen))
            var preguntasI: String =cursorP.getString(cursorP.getColumnIndex(BDPreguntasRespuestas.Pregunta))
            respuestasC=""

            for (i in 1..4){

                var idU: String = cursorP.getString(cursorP.getColumnIndex(BDPreguntasRespuestas.idTablaPreguntas)) + "0$i"
                var cursor2: Cursor =database.query(BDPreguntasRespuestas.tablaRespuestas,null,"id='$idU'",
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
        var cursor2: Cursor =database.query(BDPreguntasRespuestas.tablaPreguntas,null,null,
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
        preguntasS.set(0, "Elige Pregunta")
        val spinner: Spinner= findViewById<Spinner>(R.id.spinner2)
        if (spinner != null) {
            val adapter1 = ArrayAdapter(this,android.R.layout.simple_spinner_item, preguntasS)
            spinner.adapter = adapter1
        }


        val contenedorRecycler: RecyclerView = findViewById<RecyclerView>(R.id.vistaRecycler)
        val adapter: AdapterPreguntas = AdapterPreguntas(this, datos)
        contenedorRecycler.adapter=adapter
        contenedorRecycler.layoutManager= LinearLayoutManager(this)
    }


    fun EditaP(view: View) {

        val pregunta: EditText = findViewById<EditText>(R.id.preguntaE)
        val respuesta1: EditText = findViewById<EditText>(R.id.respuestaE1)
        val respuesta2: EditText = findViewById<EditText>(R.id.respuestaE2)
        val respuesta3: EditText = findViewById<EditText>(R.id.respuestaE3)
        val respuesta4: EditText = findViewById<EditText>(R.id.respuestaE4)
        val spin: Spinner = findViewById<Spinner>(R.id.spinner2)
        val registro = ContentValues()
        registro.put("Pregunta", pregunta.text.toString())

        var res1: String =respuesta1.text.toString()
        var res2: String =respuesta2.text.toString()
        var res3: String =respuesta3.text.toString()
        var res4: String =respuesta4.text.toString()
        var imag: Int = 0
        var tp: String = ""
        var idU: String = ""
        for (i in 1..4){
            var Putili: String = spin.selectedItemId.toString()
            var cursor: Cursor =database.query(BDPreguntasRespuestas.tablaPreguntas,null,"id='$Putili'",
                    null,null,null,BDPreguntasRespuestas.idTablaPreguntas+" asc")
            cursor.moveToFirst()
            var correcta: String = "incorrecta"
            imag = cursor.getInt(cursor.getColumnIndex(BDPreguntasRespuestas.Imagen))
            idU =  cursor.getInt(cursor.getColumnIndex(BDPreguntasRespuestas.idTablaPreguntas)).toString()
            tp = cursor.getInt(cursor.getColumnIndex(BDPreguntasRespuestas.tipo)).toString()
            var laP: String = cursor.getInt(cursor.getColumnIndex(BDPreguntasRespuestas.idTablaRespuestas)).toString() + "0$i"
            val registro2 = ContentValues()
            registro2.put("id", laP)
            if (i==1){
                registro2.put("respuesta", res1)
            }else if (i==2){
                registro2.put("respuesta", res2)
                correcta= "correcta"
            }else if (i==3){
                registro2.put("respuesta", res3)
            }else if (i==4){
                registro2.put("respuesta", res4)
            }
            registro2.put("tipo", tp)
            registro2.put("preguntaCorrecta", correcta)
            if (database.update(BDPreguntasRespuestas.tablaRespuestas, registro2, "id=${laP}", null) > 0) {
                Toast.makeText(this, "Respuesta Cambiada", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Error en el proceso", Toast.LENGTH_LONG).show()
            }
        }
        registro.put("Imagen", imag)
        registro.put("tipo", tp)
        if (database.update(BDPreguntasRespuestas.tablaPreguntas, registro, "id=${idU}", null) > 0) {
            Toast.makeText(this, "Pregunta Cambiada", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Error en el proceso", Toast.LENGTH_LONG).show()
        }

        Refrescar()

    }


}