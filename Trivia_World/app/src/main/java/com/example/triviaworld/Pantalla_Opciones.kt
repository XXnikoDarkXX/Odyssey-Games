package com.example.triviaworld

import Adapters.AdapterOpciones
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Pantalla_Opciones : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_opciones)

        val datos:ArrayList<String> = arrayListOf("Usuario","Contraseña Antigua","Contraseña Nueva")

        //hago referencia al recycle
        val recycleOpciones:RecyclerView = findViewById(R.id.recycleOpciones)
        //creamos el adapter
        val adapter:AdapterOpciones = AdapterOpciones(this,datos)
        //a nuestro recycleview le metemos el adapter creado
        recycleOpciones.adapter=adapter

        //Establecemos el LayoutManager para que se ocupe de mostrar los datos de la lista
        recycleOpciones.layoutManager= LinearLayoutManager(this)

    }

    fun irAInicio(view: View) {
        var intent:Intent= Intent(this, MainActivity::class.java)
        this.startActivity(intent)

    }

    /**
     * Funcion para cambiar contraseña
     * En caso de que no se rellene algun campo se validará y dará una alerta
     */
    fun cambiaPass(view: View) {
        //voy a realizar la validacion de campos
      //  var user: EditText =findViewById(R.id.cambioUsuario)
       // var contraseñaAntigua: EditText =findViewById(R.id.passAntigua)
       // var contraseñaActual: EditText =findViewById(R.id.passNueva)
        val recycleOpciones:RecyclerView = findViewById(R.id.recycleOpciones)

      /*  var hijos:Sequence<View> =recycleOpciones.children
        val it:Iterator<View>//Creamos un iterador para iterar el recycleview
        it=hijos.iterator()
        var textos:ArrayList<String> = ArrayList<String>();//meteremos en este array los botones

        while(it.hasNext()){
            textos.add((it.next() as EditText).text.toString())//Metemos todos los botones hijos en la variable botones
        }
        Toast.makeText(this,textos.get(0),Toast.LENGTH_LONG).show()
        Toast.makeText(this,textos.get(1),Toast.LENGTH_LONG).show()
        Toast.makeText(this,textos.get(2),Toast.LENGTH_LONG).show()


            if (user.text.toString().equals("")||contraseñaActual.text.toString().equals("")||contraseñaAntigua.text.toString().equals("")){
                 android.app.AlertDialog.Builder(this)
                         .setTitle("Cambio de contraseña")
                         .setMessage("Hay un campo que no tienes rellenado")
                         .setPositiveButton(android.R.string.ok,
                                 DialogInterface.OnClickListener { dialog, which ->
                                     //botón OK pulsado
                                 })

                         .show()
             }else {

                 android.app.AlertDialog.Builder(this)
                         .setTitle("Cambio de contraseña")
                         .setMessage("Has cambiado la contraseña")
                         .setPositiveButton(android.R.string.ok,
                                 DialogInterface.OnClickListener { dialog, which ->
                                     //botón OK pulsado
                                 })

                         .show()
             }
     */
    }
}