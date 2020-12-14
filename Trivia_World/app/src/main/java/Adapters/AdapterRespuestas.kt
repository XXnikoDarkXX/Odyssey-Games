package Adapters

import BBDD.BDPreguntasRespuestas
import Clases.RespuestaIntroducida
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.createDeviceProtectedStorageContext
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.triviaworld.Pantalla_Secundaria
import com.example.triviaworld.R

class AdapterRespuestas(val actividad: Activity, val datos: ArrayList<RespuestaIntroducida>) : RecyclerView.Adapter<HolderRespuestas>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderRespuestas {
        return HolderRespuestas(actividad.layoutInflater.inflate(R.layout.elementos_recycler_respuestas, parent, false))
    }


    override fun getItemCount(): Int {

        return datos.size
    }

    override fun onBindViewHolder(holder: HolderRespuestas, position: Int) {

        //val colorCorrecto = ContextCompat.getColor(actividad, R.color.green)
        //val colorInorrecto = ContextCompat.getColor(actividad, R.color.red)


        holder.botonRespuestas.setText(datos.get(position).respuesta)



        holder.botonRespuestas.setOnClickListener() {


            if (datos.get(position).correcto=="correcta"){

                holder.botonRespuestas.setBackgroundResource(R.drawable.color_respuesta_correcta)

               /*var identificador:String = cursor.getString(cursor.getColumnIndex(BDPreguntasRespuestas.idTablaPreguntas))

                var categoria:String = cursor.getString(cursor.getColumnIndex(BDPreguntasRespuestas.tipo))

                val intent = Intent(actividad.baseContext, Pantalla_Secundaria::class.java)
                var bundle: Bundle = Bundle()
                bundle.putString("categoria",categoria)
                bundle.putString("Id", identificador)
                intent.putExtras(bundle)
                startActivity(intent)*/



            }

            if (datos.get(position).correcto=="incorrecta"){

                holder.botonRespuestas.setBackgroundResource(R.drawable.color_respuesta_incorrecta)

        }

        }

    }
}