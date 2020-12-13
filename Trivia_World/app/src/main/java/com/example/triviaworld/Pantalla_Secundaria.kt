package com.example.triviaworld


import Adapters.AdapterOpciones
import Adapters.AdapterRespuestas
import Adapters.AdapterPreguntas
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Pantalla_Secundaria: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bundle: Bundle? = intent.extras
        var valores:ArrayList<String>? = bundle?.getStringArrayList("tipo")
        setContentView(R.layout.pantalla_secundaria)


        val datos: ArrayList<String> = ArrayList<String>()



        /*datos.add(resources.getString(R.string.boton1))
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
                    imagen.setImageResource(R.drawable.imagen1_arte)
                    pregunta.text=resources.getString(R.string.pregunta1_arte)
                    datos.add(resources.getString(R.string.respuesta1_arte))
                    datos.add(resources.getString(R.string.respuesta2_arte))
                    datos.add(resources.getString(R.string.respuesta3_arte))
                    datos.add(resources.getString(R.string.respuesta4_arte))
                }
                "Historia"-> {
                    imagen.setImageResource(R.drawable.imagen_prueba)
                    pregunta.text=resources.getString(R.string.pregunta1_historia)
                    datos.add(resources.getString(R.string.respuesta1_historia))
                    datos.add(resources.getString(R.string.respuesta2_historia))
                    datos.add(resources.getString(R.string.respuesta3_historia))
                    datos.add(resources.getString(R.string.respuesta4_historia))
                }
                "Entretenimiento"-> {
                    imagen.setImageResource(R.drawable.imagen1_entretenimiento)
                    pregunta.text=resources.getString(R.string.pregunta1_entretenimiento)
                    datos.add(resources.getString(R.string.respuesta1_entretenimiento))
                    datos.add(resources.getString(R.string.respuesta2_entretenimiento))
                    datos.add(resources.getString(R.string.respuesta3_entretenimiento))
                    datos.add(resources.getString(R.string.respuesta4_entretenimiento))
                }
                "Ciencia"-> {
                    imagen.setImageResource(R.drawable.imagen1_ciencias)
                    pregunta.text=resources.getString(R.string.pregunta1_ciencias)
                    datos.add(resources.getString(R.string.respuesta1_ciencias))
                    datos.add(resources.getString(R.string.respuesta2_ciencias))
                    datos.add(resources.getString(R.string.respuesta3_ciencias))
                    datos.add(resources.getString(R.string.respuesta4_ciencias))
                }
                "Geografía"-> {
                    imagen.setImageResource(R.drawable.imagen1_geografia)
                    pregunta.text=resources.getString(R.string.pregunta1_geografia)
                    datos.add(resources.getString(R.string.respuesta1_geografia))
                    datos.add(resources.getString(R.string.respuesta2_geografia))
                    datos.add(resources.getString(R.string.respuesta3_geografia))
                    datos.add(resources.getString(R.string.respuesta4_geografia))
                }


            }

            adapter = AdapterRespuestas(this,datos)
            recyclerRespuestas.adapter=adapter
            recyclerRespuestas.layoutManager= LinearLayoutManager(this)
        }

    }
}