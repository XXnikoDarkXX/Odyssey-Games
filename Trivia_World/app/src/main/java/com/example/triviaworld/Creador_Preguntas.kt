package com.example.triviaworld

import BBDD.BDPreguntasRespuestas
import android.Manifest
import android.content.ContentValues
import android.content.pm.PackageManager
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat


class Creador_Preguntas : AppCompatActivity() {

    companion object val PERMISO_ALMACENAMIENTO=1000;
    val database: SQLiteDatabase by lazy{ BDPreguntasRespuestas(this).writableDatabase }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.creador__preguntas)
    }
    //subirImagen

    fun subirImagen(view: View) {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Me has concedido permiso", Toast.LENGTH_LONG).show()
        } else {
            //si le doy a permiso en negativo me dara este error
            if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                Toast.makeText(this, R.string.PermisoDenegadoAlmacenamiento, Toast.LENGTH_LONG).show()
            }

            val permisos:Array<String> = arrayOf<String>(Manifest.permission.READ_EXTERNAL_STORAGE)//metemos el permiso a un array de String
            ActivityCompat.requestPermissions(this, permisos, PERMISO_ALMACENAMIENTO)
        }

        val pregunta: EditText = findViewById<EditText>(R.id.preguntaI)
        val imagen: ImageButton = findViewById<ImageButton>(R.id.imagenP)
        val spin: Spinner = findViewById<Spinner>(R.id.spinner)
        val respuesta1: EditText = findViewById<EditText>(R.id.respuesta1)
        val respuesta2: EditText = findViewById<EditText>(R.id.respuesta2)
        val respuesta3: EditText = findViewById<EditText>(R.id.respuesta3)
        val respuesta4: EditText = findViewById<EditText>(R.id.respuesta4)
        val registro = ContentValues()
        registro.put("Pregunta", pregunta.text.toString())
        registro.put("Imagen", R.drawable.imagen1_entretenimiento)
        registro.put("tipo", spin.selectedItemId.toString())
        if (database.insert(BDPreguntasRespuestas.tablaPreguntas, null, registro) > 0) {
            Toast.makeText(this, "Pregunta Ingresada", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Error en el proceso", Toast.LENGTH_LONG).show()
        }

        var res1: String =respuesta1.text.toString()
        var res2: String =respuesta2.text.toString()
        var res3: String =respuesta3.text.toString()
        var res4: String =respuesta4.text.toString()
        for (i in 1..4){
            var Putili: String = pregunta.text.toString()
            var cursor: Cursor =database.query(BDPreguntasRespuestas.tablaPreguntas,null,"Pregunta='$Putili'",
                    null,null,null,BDPreguntasRespuestas.idTablaPreguntas+" asc")
            cursor.moveToFirst()
            var laP: String = cursor.getInt(cursor.getColumnIndex(BDPreguntasRespuestas.idTablaRespuestas)).toString() + "0$i"
            val registro2 = ContentValues()
            registro2.put("id", laP)
            if (i==1){
                registro2.put("respuesta", res1)
            }else if (i==2){
                registro2.put("respuesta", res2)
            }else if (i==3){
                registro2.put("respuesta", res3)
            }else if (i==4){
                registro2.put("respuesta", res4)
            }
            registro2.put("tipo", spin.selectedItemId.toString())
            if (database.insert(BDPreguntasRespuestas.tablaRespuestas, null, registro2) > 0) {
                Toast.makeText(this, "Respuesta Ingresada", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Error en el proceso", Toast.LENGTH_LONG).show()
            }
        }


    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==PERMISO_ALMACENAMIENTO){
            if(grantResults.size>0&&grantResults.get(0)== PackageManager.PERMISSION_GRANTED){
                //lanzamos la actividad
            }else{
                //Manejarla como queramos.
                Toast.makeText(this, R.string.almacenamientoDenegado, Toast.LENGTH_LONG).show()
            }
        }

    }


}