package Adapters

import Clases.Preguntas
import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.triviaworld.R
import java.io.BufferedInputStream
import java.io.IOException
import java.io.InputStream
import java.net.URL
import java.net.URLConnection

class ListaPreguntas (val actividad: Activity, val datos:ArrayList<Preguntas>): BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater : LayoutInflater = actividad.layoutInflater
        val vista: View = inflater.inflate(R.layout.elementos_listview, null)

        val preguntas: TextView = vista.findViewById(R.id.preguntas)
        val imagen: ImageView = vista.findViewById(R.id.imagen)
        val respuestas: TextView = vista.findViewById(R.id.respuestas)

        preguntas.text = datos.get(position).pregunta
        respuestas.text = datos.get(position).respuestas
        imagen.setImageResource(datos.get(position).imagen)

        return vista
    }

    override fun getItem(position: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getItemId(position: Int): Long {
        TODO("Not yet implemented")
    }

    override fun getCount(): Int {
        return datos.size;
    }


}