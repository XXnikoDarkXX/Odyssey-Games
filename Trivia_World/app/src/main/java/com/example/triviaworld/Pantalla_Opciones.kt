package com.example.triviaworld

import BBDD.BDPersona
import Clases.Persona
import android.content.ContentValues
import android.content.DialogInterface
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Pantalla_Opciones : AppCompatActivity() {
    val database: SQLiteDatabase by lazy { BDPersona(this).writableDatabase }
    val personas: ArrayList<Persona> = arrayListOf<Persona>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_opciones)

        val datos: ArrayList<String> = arrayListOf("Usuario", "Contraseña Antigua", "Contraseña Nueva")


    }

    fun irAInicio(view: View) {
        var intent: Intent = Intent(this, MainActivity::class.java)
        this.startActivity(intent)

    }

    /**
     * Funcion para cambiar contraseña
     * En caso de que no se rellene algun campo se validará y dará una alerta
     */
    fun cambiaPass(view: View) {

        refrecarUsuarios()

        var user: EditText = findViewById(R.id.cambioUsuario)
        var contraseñaAntigua: EditText = findViewById(R.id.passAntigua)
        var contraseñaNueva :EditText = findViewById(R.id.passNueva)

        var passNueva: String = contraseñaNueva.text.toString()
        var passAntigua: String = contraseñaAntigua.text.toString()
        var usuarioCampo: String = user.text.toString()

        if (user.text.toString().equals("") || contraseñaNueva.text.toString().equals("") || contraseñaAntigua.text.toString().equals("")) {
            android.app.AlertDialog.Builder(this)
                    .setTitle("Cambio de contraseña")
                    .setMessage("Hay un campo que no tienes rellenado")
                    .setPositiveButton(android.R.string.ok,
                            DialogInterface.OnClickListener { dialog, which ->
                                //botón OK pulsado
                            })

                    .show()
        } else {


            android.app.AlertDialog.Builder(this)
                    .setTitle("Cambio de contraseña")
                    .setMessage("Has cambiado la contraseña")
                    .setPositiveButton(android.R.string.ok,
                            DialogInterface.OnClickListener { dialog, which ->
                                //botón OK pulsado
                            })

                    .show()


            //update Persona set contraseña=X, contraseñaNuva=Y where Usuario=z

            //vamos a hacer un toast del usuario que se escriba en el editText




            var contador=0
            while(contador<personas.size){

              if (personas.get(contador).usuario.equals(usuarioCampo)){



               //comprobamos que la contraseña que ha puesto antigua sea la misma que la de la bbdd
                  if (personas.get(contador).contraseña.equals(passAntigua)){
                      val datosAModificar: ContentValues = ContentValues()
                      datosAModificar.put(BDPersona.contraseña, "pepe")
                      if(database.update(BDPersona.tablaPersona,datosAModificar,
                                      "id='${this.personas.get(contador).id}'",null) >0){

                      }
                  }
              }
                  contador++;
            }
















        }


    }

    fun refrecarUsuarios(){



        var cursor: Cursor = database.query(BDPersona.tablaPersona, null, null,
                null, null, null, BDPersona.usuario + " desc")
        cursor.moveToFirst()//movemos el cursos al primer registro

        while (!cursor.isAfterLast) {//iteramos el cursos hasta el ultimo registro
            //iremos añadiendo las tablas a nuestro arrayList
            val personaId:Int= cursor.getInt(cursor.getColumnIndex(BDPersona.idPersona))
            val personaUsuario: String = cursor.getString(cursor.getColumnIndex(BDPersona.usuario))
            val personaNombre: String = cursor.getString(cursor.getColumnIndex(BDPersona.nombre))
            val personaApellidos: String = cursor.getString(cursor.getColumnIndex(BDPersona.apellidos))
            val fechaDeNacimiento: String = cursor.getString(cursor.getColumnIndex(BDPersona.fechaNacimiento))
            val personaDireccion: String = cursor.getString(cursor.getColumnIndex(BDPersona.direccion))
            val personaCiudad: String = cursor.getString(cursor.getColumnIndex(BDPersona.ciudad))
            val personaPais: String = cursor.getString(cursor.getColumnIndex(BDPersona.pais))

            val personaTelefono: String = cursor.getString(cursor.getColumnIndex(BDPersona.telefono))
            val personaContraseña: String = cursor.getString(cursor.getColumnIndex(BDPersona.contraseña))

            personas.add(Persona(personaId,personaNombre, personaApellidos, fechaDeNacimiento, personaDireccion, personaCiudad, personaPais, personaTelefono,
                    personaUsuario, personaContraseña))

            cursor.moveToNext()

        }
        Toast.makeText(this,"contraeña es"+personas.get(1).contraseña,Toast.LENGTH_LONG).show()
    }
}