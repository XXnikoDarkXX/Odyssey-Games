package Adapters

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.triviaworld.R

class HolderRespuestas(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val botonRespuestas:Button by lazy { itemView.findViewById<Button>(R.id.boton1respuesta) }


}