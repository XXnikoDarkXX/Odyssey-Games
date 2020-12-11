package Adapters

import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.triviaworld.R

class HolderPreguntas(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val imagen: ImageView by lazy{ itemView.findViewById<ImageView>(R.id.imagen)}

    val preguntas: TextView by lazy{ itemView.findViewById<TextView>(R.id.preguntas)}

    val respuesta: TextView by lazy{ itemView.findViewById<TextView>(R.id.respuestas)}

}
