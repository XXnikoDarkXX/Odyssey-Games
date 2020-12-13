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


        /*preguntas.add(Preguntas(R.drawable.imagen_prueba,  resources.getString(R.string.pregunta1_historia) ,  resources.getString(R.string.respuesta1_historia)+"\n" +
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
                +"\n" +resources.getString(R.string.respuesta4_ciencias)))*/

        /*var cursor: Cursor = database.query(BDPreguntasRespuestas.tablaRespuestas,null,null,
                null,null,null, BDPreguntasRespuestas.idTablaRespuestas+" asc")
        cursor.moveToFirst()*/
        //var aux: Byte = 0
        /*while(!cursor.isAfterLast){
            aux++
            cursor.moveToNext()
        }
        cursor.moveToFirst()
        for (i in 1..aux){

        }
        while(!cursor.isAfterLast){
            val id:Int=cursor.getInt(cursor.getColumnIndex(BDPreguntasRespuestas.cienciasTablaRespuestas))
            val respuesta:String=cursor.getString(cursor.getColumnIndex(BDPreguntasRespuestas.cienciasTablaRespuestas))

            respuestasC.add(respuesta)

            cursor.moveToNext()
        }*/

        /*cursor =database.query(BDPreguntasRespuestas.tablaPreguntas,null,null,
                null,null,null, BDPreguntasRespuestas.idTablaPreguntas+" asc")
        cursor.moveToFirst()
        while(!cursor.isAfterLast){
            val id:Int=cursor.getInt(cursor.getColumnIndex(BDPreguntasRespuestas.idTablaPreguntas))
            val preguntaI:String=cursor.getString(cursor.getColumnIndex(BDPreguntasRespuestas.Pregunta))

            var idU: Int = id
            var cursor2: Cursor = database.query(BDPreguntasRespuestas.tablaRespuestas,null,"id='$idU'",
                    null,null,null, BDPreguntasRespuestas.idTablaRespuestas+" asc")
            cursor2.moveToFirst()
            respuestasC+= cursor.getString(cursor.getColumnIndex(BDPreguntasRespuestas.idTablaRespuestas)) + "\n"


            cursor.moveToNext()
        }
        /*imagen.setImageResource(cursor.getInt(cursor.getColumnIndex(BDPreguntasRespuestas.Imagen)))
        pregunta.text=cursor.getString(cursor.getColumnIndex(BDPreguntasRespuestas.Pregunta))*/

        val contenedorRecycler: RecyclerView = findViewById<RecyclerView>(R.id.vistaRecycler)
        val adapter: AdapterPreguntas = AdapterPreguntas(this, datos)
        contenedorRecycler.adapter=adapter
        contenedorRecycler.layoutManager= LinearLayoutManager(this)*/


        var datos:ArrayList<Preguntas> = ArrayList<Preguntas>()
        var preguntaD: Preguntas =  Preguntas(2,"","")
        var respuestasC: String = ""

        var cursor: Cursor =database.query(BDPreguntasRespuestas.tablaPreguntas,null,"tipo='historia' and id='2'",
                null,null,null,BDPreguntasRespuestas.idTablaPreguntas+" asc")
        cursor.moveToFirst()
        var imagenI: Int = cursor.getInt(cursor.getColumnIndex(BDPreguntasRespuestas.Imagen))
        var preguntasI: String =cursor.getString(cursor.getColumnIndex(BDPreguntasRespuestas.Pregunta))


        for (i in 1..4){

            var idU: String = cursor.getString(cursor.getColumnIndex(BDPreguntasRespuestas.idTablaPreguntas)) + "0$i"
            var cursor2: Cursor =database.query(BDPreguntasRespuestas.tablaRespuestas,null,"tipo='historia' and id='$idU'",
                    null,null,null,BDPreguntasRespuestas.tipo+" asc")
            cursor2.moveToFirst()
            val respuesta:String=cursor2.getString(cursor2.getColumnIndex(BDPreguntasRespuestas.respuesta))
            respuestasC+= respuesta + "\n"

        }

        datos.add(Preguntas(imagenI, preguntasI, respuestasC))

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

}