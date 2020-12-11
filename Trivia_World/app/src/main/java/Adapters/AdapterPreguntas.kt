package Adapters

import Clases.Preguntas
import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.triviaworld.R

class AdapterPreguntas(val actividad: Activity, val datos: ArrayList<Preguntas>) : RecyclerView.Adapter<HolderPreguntas>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderPreguntas {
        return HolderPreguntas(actividad.layoutInflater.inflate(R.layout.elementos_recycler_preguntas, parent, false))
    }

    override fun getItemCount(): Int {
        return datos.size
    }

    override fun onBindViewHolder(holder: HolderPreguntas, position: Int) {

        holder.preguntas.text = datos.get(position).pregunta
        holder.respuesta.text = datos.get(position).respuestas
        holder.imagen.setImageResource(datos.get(position).imagen)

    }

}