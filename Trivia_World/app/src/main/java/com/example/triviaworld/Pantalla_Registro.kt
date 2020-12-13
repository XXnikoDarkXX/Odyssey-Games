package com.example.triviaworld

import Adapters.AdapterRegistro
import BBDD.BDPersona
import Clases.Persona
import android.content.ContentValues
import android.content.DialogInterface
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Pantalla_Registro : AppCompatActivity() {

    val database: SQLiteDatabase by lazy{ BDPersona(this).writableDatabase }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_registro)


    }


    /**
     * Función para ir a la página de inicio pulsando el logo, mediante un intent
     */
    fun volverInicio(view: View) {

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    /**
     *Función para registrarse, comprueba que todos los datos estan rellenos
     */
    fun enviarRegistro(view: View) {

        //Referencio las variables
        var nombreRegistro: EditText = findViewById(R.id.nombreRegistro)
        var apellidosRegistro: EditText = findViewById(R.id.apellidosRegistro)
        var fechaNacimientoRegistro: EditText = findViewById(R.id.fechaNacimientoRegistro)
        var direccionRegistro: EditText = findViewById(R.id.direccionRegistro)
        var ciudadRegistro: EditText = findViewById(R.id.ciudadRegistro)
        var paisRegistro: EditText = findViewById(R.id.paisRegistro)
        var telefonoRegistro: EditText = findViewById(R.id.telefonoRegistro)
        var usuarioRegistro: EditText = findViewById(R.id.usuarioRegistro)
        var contraseñaRegistro: EditText = findViewById(R.id.contraseñaRegistro)
        var contraseñaComprobacionRegistro: EditText = findViewById(R.id.contraseñaComprobacionRegistro)


        //Guardo los campos recibidos en variables de tipo string
        var nombreRegi: String = nombreRegistro.text.toString()
        var apellidosRegi: String = apellidosRegistro.text.toString()
        var fechaNacimientoRegi: String = fechaNacimientoRegistro.text.toString()
        var direccionRegi: String = direccionRegistro.text.toString()
        var diudadRegi: String = ciudadRegistro.text.toString()
        var paisRegi: String = paisRegistro.text.toString()
        var telefonoRegi: String = telefonoRegistro.text.toString()
        var usuarioRegi: String = usuarioRegistro.text.toString()
        var contraseñaRegi: String = contraseñaRegistro.text.toString()
        var contraseñaComprobacionRegi: String = contraseñaComprobacionRegistro.text.toString()


        //Verificación de datos completados
        if (nombreRegi == "") {

            //Dialogo de alerta que avisa de la acción
            AlertDialog.Builder(this).setTitle("Datos incompletos").setMessage("Falta: nombre").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which -> }).show()

        } else if (apellidosRegi == "") {
            AlertDialog.Builder(this).setTitle("Datos incompletos").setMessage("Falta: apellidos").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which -> }).show()

        } else if (fechaNacimientoRegi == "") {
            AlertDialog.Builder(this).setTitle("Datos incompletos").setMessage("Falta: fecha de nacimiento").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which -> }).show()

        } else if (direccionRegi == "") {
            AlertDialog.Builder(this).setTitle("Datos incompletos").setMessage("Falta: dirección").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which -> }).show()

        } else if (diudadRegi == "") {
            AlertDialog.Builder(this).setTitle("Datos incompletos").setMessage("Falta: ciudad").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which -> }).show()

        } else if (paisRegi == "") {
            AlertDialog.Builder(this).setTitle("Datos incompletos").setMessage("Falta: pais").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which -> }).show()

        } else if (telefonoRegi == "") {
            AlertDialog.Builder(this).setTitle("Datos incompletos").setMessage("Falta: telefono").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which -> }).show()

        } else if (usuarioRegi == "") {
            AlertDialog.Builder(this).setTitle("Datos incompletos").setMessage("Falta: usuario").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which -> }).show()

        } else if (contraseñaRegi == "") {
            AlertDialog.Builder(this).setTitle("Datos incompletos").setMessage("Falta: contraseña").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which -> }).show()

        } else if (contraseñaComprobacionRegi == "") {
            AlertDialog.Builder(this).setTitle("Datos incompletos").setMessage("Falta: comprobación contraseña").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which -> }).show()

        } else {

            if (contraseñaRegi.equals(contraseñaComprobacionRegi)) {

                //Dialogo de alerta que avisa de la acción
                AlertDialog.Builder(this).setTitle("Registrarse").setMessage("Registrado").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which -> }).show()


                //INSERCCION EN LA BASE DE DATOS DE USUSARIOS//

                //referenciamos los campos q van a intervenir en la funcionalidad
                val nombreRegistro: EditText = findViewById<EditText>(R.id.nombreRegistro)
                val apellidosRegistro: EditText = findViewById<EditText>(R.id.apellidosRegistro)
                val fechaNacimientoRegistro: EditText = findViewById<EditText>(R.id.fechaNacimientoRegistro)
                val direccionRegistro: EditText = findViewById<EditText>(R.id.direccionRegistro)
                val ciudadRegistro: EditText = findViewById<EditText>(R.id.ciudadRegistro)
                val paisRegistro: EditText = findViewById<EditText>(R.id.paisRegistro)
                val telefonoRegistro: EditText = findViewById<EditText>(R.id.telefonoRegistro)
                val usuarioRegistro: EditText = findViewById<EditText>(R.id.usuarioRegistro)
                val contraseñaRegistro: EditText = findViewById<EditText>(R.id.contraseñaRegistro)


                //tipo ContentValues: donde se van a meter datos de tipo clave-valor (clave=nombre columna,valor=lo ingresa el usuario)
                val datosAInsertar: ContentValues = ContentValues()

                //clave=nombre columna y valor viene de campoUsuario
                datosAInsertar.put(BDPersona.nombre, nombreRegistro.text.toString())
                datosAInsertar.put(BDPersona.apellidos, apellidosRegistro.text.toString())
                datosAInsertar.put(BDPersona.fechaNacimiento, fechaNacimientoRegistro.text.toString())
                datosAInsertar.put(BDPersona.direccion, direccionRegistro.text.toString())
                datosAInsertar.put(BDPersona.ciudad, ciudadRegistro.text.toString())
                datosAInsertar.put(BDPersona.pais, paisRegistro.text.toString())
                datosAInsertar.put(BDPersona.telefono, telefonoRegistro.text.toString())
                datosAInsertar.put(BDPersona.usuario, usuarioRegistro.text.toString())
                datosAInsertar.put(BDPersona.contraseña, contraseñaRegistro.text.toString())


                //database.insert:inserta en la base de datos ; (nombre de la tabla, null, datosAInsertar)
                if (database.insert(BDPersona.tablaPersona, null, datosAInsertar) > 0) {
                    Toast.makeText(this, R.string.usuarioInsertado, Toast.LENGTH_LONG).show()

                    val intent = Intent(this, Pantalla_Login::class.java)
                    startActivity(intent)

                } else {
                    Toast.makeText(this, R.string.errorInsertandoUsuario, Toast.LENGTH_LONG).show()
                }


            }else{
                Toast.makeText(this, R.string.errorContraseñaDistintas, Toast.LENGTH_LONG).show()
            }
        }
    }



}





























