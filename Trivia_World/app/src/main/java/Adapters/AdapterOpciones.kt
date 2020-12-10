package Adapters

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.triviaworld.R
import java.util.*
import kotlin.collections.ArrayList

class AdapterOpciones (val actividad: Activity, val datos: ArrayList<String>): RecyclerView.Adapter<HolderOpciones>(){

    /**
     * Metodo que infla cada uno de los elementos en el Layout, a traves del ViewHolder que creamos
     * devuelve un objeto HolderOpciones
     * @param parent es la lista
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderOpciones {
        return HolderOpciones( actividad.layoutInflater.inflate(R.layout.elementos_opciones,parent,false))
    }


    /**
     * Sirve para saber cuanto es el tamaño de la lista
     */
    override fun getItemCount(): Int {
        return datos.size //es importante ponerlo para que coja todo los elementos de la lista
    }

    /**
     * Este metodo se ejecuta por cada vez que se infla un elemento en la lista
     * @param holder objeto de tipo MiHolder que hemos creado
     * @param position el atributo del de arriba nos indica que elemento de la lista se está enlazando empezando desde cero
     */
    override fun onBindViewHolder(holder: HolderOpciones, position: Int) {
       holder.entradaOpciones.setText(datos.get(position))


    }
}