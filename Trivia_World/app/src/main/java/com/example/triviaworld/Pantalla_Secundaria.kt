package com.example.triviaworld



import Adapters.AdapterRespuestas
import Adapters.AdapterPreguntas
import BBDD.BDPreguntasRespuestas
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Pantalla_Secundaria: AppCompatActivity() {

    val database: SQLiteDatabase by lazy{ BDPreguntasRespuestas(this).writableDatabase }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bundle: Bundle? = intent.extras
        var valores:ArrayList<String>? = bundle?.getStringArrayList("tipo")
        setContentView(R.layout.pantalla_secundaria)


        val datos: ArrayList<String> = ArrayList<String>()

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

                    cursor =database.query(BDPreguntasRespuestas.tablaRespuestas,null,"id='re'",
                            null,null,null,BDPreguntasRespuestas.idTablaRespuestas+" asc")
                    cursor.moveToFirst()
                    while(!cursor.isAfterLast){
                        val id:Int=cursor.getInt(cursor.getColumnIndex(BDPreguntasRespuestas.idTablaRespuestas))
                        val pregunta:String=cursor.getString(cursor.getColumnIndex(BDPreguntasRespuestas.respuesta))

                        datos.add(pregunta)

                        cursor.moveToNext()
                    }

                    cursor =database.query(BDPreguntasRespuestas.tablaPreguntas,null,"id='4'",
                            null,null,null,BDPreguntasRespuestas.idTablaPreguntas+" asc")
                    cursor.moveToFirst()
                    val imagen: ImageView =findViewById<ImageView>(R.id.imagen_secundaria)
                    val pregunta: TextView = findViewById<TextView>(R.id.textoPregunta)
                    imagen.setImageResource(cursor.getInt(cursor.getColumnIndex(BDPreguntasRespuestas.Imagen)))
                    pregunta.text=cursor.getString(cursor.getColumnIndex(BDPreguntasRespuestas.Pregunta))
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

                        datos.add(cursor2.getString(cursor2.getColumnIndex(BDPreguntasRespuestas.respuesta)))

                    }

                    //datos.add(respuestaI)


                }
                "Entretenimiento"-> {

                    cursor =database.query(BDPreguntasRespuestas.tablaRespuestas,null,null,
                            null,null,null,BDPreguntasRespuestas.idTablaRespuestas+" asc")
                    cursor.moveToFirst()
                    while(!cursor.isAfterLast){
                        val id:Int=cursor.getInt(cursor.getColumnIndex(BDPreguntasRespuestas.idTablaRespuestas))
                        val pregunta:String=cursor.getString(cursor.getColumnIndex(BDPreguntasRespuestas.idTablaRespuestas))

                        datos.add(pregunta)

                        cursor.moveToNext()
                    }

                    cursor =database.query(BDPreguntasRespuestas.tablaPreguntas,null,"id='5'",
                            null,null,null,BDPreguntasRespuestas.idTablaPreguntas+" asc")
                    cursor.moveToFirst()
                    val imagen: ImageView =findViewById<ImageView>(R.id.imagen_secundaria)
                    val pregunta: TextView = findViewById<TextView>(R.id.textoPregunta)
                    imagen.setImageResource(cursor.getInt(cursor.getColumnIndex(BDPreguntasRespuestas.Imagen)))
                    pregunta.text=cursor.getString(cursor.getColumnIndex(BDPreguntasRespuestas.Pregunta))
                }
                "Ciencia"-> {

                    cursor =database.query(BDPreguntasRespuestas.tablaRespuestas,null,null,
                            null,null,null,BDPreguntasRespuestas.idTablaRespuestas+" asc")
                    cursor.moveToFirst()
                    while(!cursor.isAfterLast){
                        val id:Int=cursor.getInt(cursor.getColumnIndex(BDPreguntasRespuestas.idTablaRespuestas))
                        val pregunta:String=cursor.getString(cursor.getColumnIndex(BDPreguntasRespuestas.idTablaRespuestas))

                        datos.add(pregunta)

                        cursor.moveToNext()
                    }

                    cursor =database.query(BDPreguntasRespuestas.tablaPreguntas,null,"id='3'",
                            null,null,null,BDPreguntasRespuestas.idTablaPreguntas+" asc")
                    cursor.moveToFirst()
                    val imagen: ImageView =findViewById<ImageView>(R.id.imagen_secundaria)
                    val pregunta: TextView = findViewById<TextView>(R.id.textoPregunta)
                    imagen.setImageResource(cursor.getInt(cursor.getColumnIndex(BDPreguntasRespuestas.Imagen)))
                    pregunta.text=cursor.getString(cursor.getColumnIndex(BDPreguntasRespuestas.Pregunta))
                }
                "Geografía"-> {

                    cursor =database.query(BDPreguntasRespuestas.tablaRespuestas,null,null,
                            null,null,null,BDPreguntasRespuestas.idTablaRespuestas+" asc")
                    cursor.moveToFirst()
                    while(!cursor.isAfterLast){
                        val id:Int=cursor.getInt(cursor.getColumnIndex(BDPreguntasRespuestas.idTablaRespuestas))
                        val pregunta:String=cursor.getString(cursor.getColumnIndex(BDPreguntasRespuestas.idTablaRespuestas))

                        datos.add(pregunta)

                        cursor.moveToNext()
                    }

                    cursor =database.query(BDPreguntasRespuestas.tablaPreguntas,null,"id='2'",
                            null,null,null,BDPreguntasRespuestas.idTablaPreguntas+" asc")
                    cursor.moveToFirst()
                    val imagen: ImageView =findViewById<ImageView>(R.id.imagen_secundaria)
                    val pregunta: TextView = findViewById<TextView>(R.id.textoPregunta)
                    imagen.setImageResource(cursor.getInt(cursor.getColumnIndex(BDPreguntasRespuestas.Imagen)))
                    pregunta.text=cursor.getString(cursor.getColumnIndex(BDPreguntasRespuestas.Pregunta))
                }


            }

            adapter = AdapterRespuestas(this,datos)
            recyclerRespuestas.adapter=adapter
            recyclerRespuestas.layoutManager= LinearLayoutManager(this)
        }else{
            var lil: Cursor =database.query(BDPreguntasRespuestas.tablaPreguntas,null,null,
                    null,null,null,BDPreguntasRespuestas.idTablaPreguntas+" asc")
            lil.moveToFirst()
            val imagen: ImageView =findViewById<ImageView>(R.id.imagen_secundaria)
            val pregunta: TextView = findViewById<TextView>(R.id.textoPregunta)
            imagen.setImageResource(lil.getInt(lil.getColumnIndex(BDPreguntasRespuestas.Imagen)))
            pregunta.text=lil.getString(lil.getColumnIndex(BDPreguntasRespuestas.Pregunta))

            adapter = AdapterRespuestas(this,datos)
            recyclerRespuestas.adapter=adapter
            recyclerRespuestas.layoutManager= LinearLayoutManager(this)

        }

    }
}