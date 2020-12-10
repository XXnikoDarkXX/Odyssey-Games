package Adapters

import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.triviaworld.R

class HolderRegistro (itemView: View) : RecyclerView.ViewHolder(itemView){

    val campoRegistro:EditText by lazy { itemView.findViewById<EditText>(R.id.campoRegistro) }


}