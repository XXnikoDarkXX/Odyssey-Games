package Adapters

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.triviaworld.R

class AdapterRegistro(val actividad:Activity, val datos: ArrayList<String>) : RecyclerView.Adapter<HolderRegistro>() {

    /**
     * Metodo que infla cada uno de los elementos en el Layout, a traves del ViewHolder que creamos
     * devuelve un objeto HolderRegistro
     * @param parent es la lista
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderRegistro {
        return HolderRegistro( actividad.layoutInflater.inflate(R.layout.elementos_recycler_registro,parent,false))

    }

    /**
     * Sirve para saber el tamaño de la lista
     */
    override fun getItemCount(): Int {
        return datos.size
    }

    /**
     * Este metodo se ejecuta por cada vez que se infla un elemento en la lista
     * @param holder objeto de tipo HolderRegistro que hemos creado
     * @param position el atributo del de arriba nos indica que elemento de la lista se está enlazando empezando desde cero
     */
    override fun onBindViewHolder(holder: HolderRegistro, position: Int) {
        //holder.campoRegistro.setText(datos.get(position))
        holder.campoRegistro.setHint(datos.get(position))
    }
}