package Adapters

import android.app.Activity
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.triviaworld.R

class AdapterRespuestas(val actividad: Activity, val datos: ArrayList<String>) : RecyclerView.Adapter<HolderRespuestas>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderRespuestas {
        return HolderRespuestas( actividad.layoutInflater.inflate(R.layout.elementos_recycler_respuestas,parent,false))
    }


    override fun getItemCount(): Int {

        return datos.size
    }

    override fun onBindViewHolder(holder: HolderRespuestas, position: Int) {

        holder.botonRespuestas.setText(datos.get(position))
        Toast.makeText(actividad,"funciona", Toast.LENGTH_LONG).show()
    }


}