package Adapters

import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.triviaworld.R

class HolderOpciones(itemView: View): RecyclerView.ViewHolder(itemView){

        val entradaOpciones:EditText by lazy { itemView.findViewById<EditText>(R.id.entradaOpciones) }


}