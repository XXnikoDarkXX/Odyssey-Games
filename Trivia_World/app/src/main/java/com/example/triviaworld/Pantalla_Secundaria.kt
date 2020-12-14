package com.example.triviaworld



import Adapters.AdapterRespuestas
import Adapters.AdapterPreguntas
import BBDD.BDPreguntasRespuestas
import Clases.RespuestaIntroducida
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.random.Random
import kotlin.random.nextInt

class Pantalla_Secundaria: AppCompatActivity() {

    val database: SQLiteDatabase by lazy{ BDPreguntasRespuestas(this).writableDatabase }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bundle: Bundle? = intent.extras
        var valores:ArrayList<String>? = bundle?.getStringArrayList("tipo")
        setContentView(R.layout.pantalla_secundaria)


        val datos: ArrayList<RespuestaIntroducida> = ArrayList<RespuestaIntroducida>()

        var cursor: Cursor


       /* datos.add(resources.getString(R.string.boton1))
        datos.add(resources.getString(R.string.boton2))
        datos.add(resources.getString(R.string.boton3))
        datos.add(resources.getString(R.string.boton4))*/


        //Refenciamos al recyclerView
        val recyclerRespuestas: RecyclerView = findViewById<RecyclerView>(R.id.recyclerSecundaria)

        //Creamos el adapter
        val adapter: AdapterRespuestas

        //A nuestro recyclerView le metemos el adapter creado
        /*recyclerRespuestas.adapter=adapter

        //Establecemos el LayoutManager para que se ocupe de mostrar los datos de la lista
        recyclerRespuestas.layoutManager= LinearLayoutManager(this)*/

        if(valores!=null) {
            var tipo: String = valores.get(0)
            val imagen: ImageView =findViewById<ImageView>(R.id.imagen_secundaria)
            val pregunta: TextView = findViewById<TextView>(R.id.textoPregunta)
            when(tipo){
                "Arte"-> {

                    cursor =database.query(BDPreguntasRespuestas.tablaPreguntas,null,"tipo='arte' and id='16'",
                            null,null,null,BDPreguntasRespuestas.idTablaPreguntas+" asc")
                    cursor.moveToFirst()
                    val imagen: ImageView =findViewById<ImageView>(R.id.imagen_secundaria)
                    val pregunta: TextView = findViewById<TextView>(R.id.textoPregunta)
                    imagen.setImageResource(cursor.getInt(cursor.getColumnIndex(BDPreguntasRespuestas.Imagen)))
                    pregunta.text=cursor.getString(cursor.getColumnIndex(BDPreguntasRespuestas.Pregunta))

                    var respuestaI:String=""

                    for (i in 1..4){

                        var idU: String = cursor.getString(cursor.getColumnIndex(BDPreguntasRespuestas.idTablaPreguntas)) + "0$i"
                        var cursor2: Cursor =database.query(BDPreguntasRespuestas.tablaRespuestas,null,"tipo='arte' and id='$idU'",
                                null,null,null,BDPreguntasRespuestas.tipo+" asc")
                        cursor2.moveToFirst()

                        datos.add(RespuestaIntroducida(cursor2.getString(cursor2.getColumnIndex(BDPreguntasRespuestas.preguntaCorrecta)), cursor2.getString(cursor2.getColumnIndex(BDPreguntasRespuestas.respuesta))))


                    }

                }
                "Historia"-> {


                    cursor =database.query(BDPreguntasRespuestas.tablaPreguntas,null,"tipo='historia' and id='1'",
                            null,null,null,BDPreguntasRespuestas.idTablaPreguntas+" asc")
                    cursor.moveToFirst()
                    val imagen: ImageView =findViewById<ImageView>(R.id.imagen_secundaria)
                    val pregunta: TextView = findViewById<TextView>(R.id.textoPregunta)
                    imagen.setImageResource(cursor.getInt(cursor.getColumnIndex(BDPreguntasRespuestas.Imagen)))
                    pregunta.text=cursor.getString(cursor.getColumnIndex(BDPreguntasRespuestas.Pregunta))

                    var respuestaI:String=""

                    for (i in 1..4){

                        var idU: String = cursor.getString(cursor.getColumnIndex(BDPreguntasRespuestas.idTablaPreguntas)) + "0$i"
                        var cursor2: Cursor =database.query(BDPreguntasRespuestas.tablaRespuestas,null,"tipo='historia' and id='$idU'",
                                null,null,null,BDPreguntasRespuestas.tipo+" asc")
                        cursor2.moveToFirst()

                        datos.add(RespuestaIntroducida(cursor2.getString(cursor2.getColumnIndex(BDPreguntasRespuestas.preguntaCorrecta)), cursor2.getString(cursor2.getColumnIndex(BDPreguntasRespuestas.respuesta))))

                    }


                }
                "Entretenimiento"-> {

                    cursor =database.query(BDPreguntasRespuestas.tablaPreguntas,null,"tipo='entretenimiento' and id='21'",
                            null,null,null,BDPreguntasRespuestas.idTablaPreguntas+" asc")
                    cursor.moveToFirst()
                    val imagen: ImageView =findViewById<ImageView>(R.id.imagen_secundaria)
                    val pregunta: TextView = findViewById<TextView>(R.id.textoPregunta)
                    imagen.setImageResource(cursor.getInt(cursor.getColumnIndex(BDPreguntasRespuestas.Imagen)))
                    pregunta.text=cursor.getString(cursor.getColumnIndex(BDPreguntasRespuestas.Pregunta))

                    var respuestaI:String=""

                    for (i in 1..4){

                        var idU: String = cursor.getString(cursor.getColumnIndex(BDPreguntasRespuestas.idTablaPreguntas)) + "0$i"
                        var cursor2: Cursor =database.query(BDPreguntasRespuestas.tablaRespuestas,null,"tipo='entretenimiento' and id='$idU'",
                                null,null,null,BDPreguntasRespuestas.tipo+" asc")
                        cursor2.moveToFirst()

                        datos.add(RespuestaIntroducida(cursor2.getString(cursor2.getColumnIndex(BDPreguntasRespuestas.preguntaCorrecta)), cursor2.getString(cursor2.getColumnIndex(BDPreguntasRespuestas.respuesta))))

                    }
                }
                "Ciencia"-> {

                    cursor =database.query(BDPreguntasRespuestas.tablaPreguntas,null,"tipo='ciencias' and id='11'",
                            null,null,null,BDPreguntasRespuestas.idTablaPreguntas+" asc")
                    cursor.moveToFirst()
                    val imagen: ImageView =findViewById<ImageView>(R.id.imagen_secundaria)
                    val pregunta: TextView = findViewById<TextView>(R.id.textoPregunta)
                    imagen.setImageResource(cursor.getInt(cursor.getColumnIndex(BDPreguntasRespuestas.Imagen)))
                    pregunta.text=cursor.getString(cursor.getColumnIndex(BDPreguntasRespuestas.Pregunta))

                    var respuestaI:String=""

                    for (i in 1..4){

                        var idU: String = cursor.getString(cursor.getColumnIndex(BDPreguntasRespuestas.idTablaPreguntas)) + "0$i"
                        var cursor2: Cursor =database.query(BDPreguntasRespuestas.tablaRespuestas,null,"tipo='ciencias' and id='$idU'",
                                null,null,null,BDPreguntasRespuestas.tipo+" asc")
                        cursor2.moveToFirst()

                       // datos.add(cursor2.getString(cursor2.getColumnIndex(BDPreguntasRespuestas.respuesta)))
                        datos.add(RespuestaIntroducida(cursor2.getString(cursor2.getColumnIndex(BDPreguntasRespuestas.preguntaCorrecta)), cursor2.getString(cursor2.getColumnIndex(BDPreguntasRespuestas.respuesta))))

                    }
                }
                "Geografía"-> {

                    cursor =database.query(BDPreguntasRespuestas.tablaPreguntas,null,"tipo='geografia' and id='6'",
                            null,null,null,BDPreguntasRespuestas.idTablaPreguntas+" asc")
                    cursor.moveToFirst()
                    val imagen: ImageView =findViewById<ImageView>(R.id.imagen_secundaria)
                    val pregunta: TextView = findViewById<TextView>(R.id.textoPregunta)
                    imagen.setImageResource(cursor.getInt(cursor.getColumnIndex(BDPreguntasRespuestas.Imagen)))
                    pregunta.text=cursor.getString(cursor.getColumnIndex(BDPreguntasRespuestas.Pregunta))

                    var respuestaI:String=""

                    for (i in 1..4){

                        var idU: String = cursor.getString(cursor.getColumnIndex(BDPreguntasRespuestas.idTablaPreguntas)) + "0$i"
                        var cursor2: Cursor =database.query(BDPreguntasRespuestas.tablaRespuestas,null,"tipo='geografia' and id='$idU'",
                                null,null,null,BDPreguntasRespuestas.tipo+" asc")
                        cursor2.moveToFirst()

                        datos.add(RespuestaIntroducida(cursor2.getString(cursor2.getColumnIndex(BDPreguntasRespuestas.preguntaCorrecta)), cursor2.getString(cursor2.getColumnIndex(BDPreguntasRespuestas.respuesta))))

                    }
                }


            }

            adapter = AdapterRespuestas(this,datos)
            recyclerRespuestas.adapter=adapter
            recyclerRespuestas.layoutManager= LinearLayoutManager(this)
        }else{

           var nAleatorio= Random.nextInt(1..25)

           /* var nAleatorio = 1

            var aux:Int =0

            var numRandom: Int

            while (nAleatorio!=aux){

                nAleatorio= Random.nextInt(1..25)

            }

            aux=nAleatorio*/

            cursor =database.query(BDPreguntasRespuestas.tablaPreguntas,null,"id='$nAleatorio'",
                    null,null,null,BDPreguntasRespuestas.idTablaPreguntas+" asc")
            cursor.moveToFirst()
            val imagen: ImageView =findViewById<ImageView>(R.id.imagen_secundaria)
            val pregunta: TextView = findViewById<TextView>(R.id.textoPregunta)
            imagen.setImageResource(cursor.getInt(cursor.getColumnIndex(BDPreguntasRespuestas.Imagen)))
            pregunta.text=cursor.getString(cursor.getColumnIndex(BDPreguntasRespuestas.Pregunta))

            var respuestaI:String=""

            for (i in 1..4){

                var idU: String = cursor.getString(cursor.getColumnIndex(BDPreguntasRespuestas.idTablaPreguntas)) + "0$i"
                var cursor2: Cursor =database.query(BDPreguntasRespuestas.tablaRespuestas,null,"id='$idU'",
                        null,null,null,BDPreguntasRespuestas.tipo+" asc")

                cursor2.moveToFirst()
                datos.add(RespuestaIntroducida(cursor2.getString(cursor2.getColumnIndex(BDPreguntasRespuestas.preguntaCorrecta)), cursor2.getString(cursor2.getColumnIndex(BDPreguntasRespuestas.respuesta))))

            }

            adapter = AdapterRespuestas(this,datos)
            recyclerRespuestas.adapter=adapter
            recyclerRespuestas.layoutManager= LinearLayoutManager(this)

        }

    }


    fun volverSeleccion(view: View) {


        val intent = Intent(this, Pantalla_eleccionJuego::class.java)
        startActivity(intent)


    }

}