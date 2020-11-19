package com.example.triviaworld

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class Pantalla_Registro : AppCompatActivity() {
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
        var nombreRegistro:EditText=findViewById(R.id.nombreRegistro)
        var apellidosRegistro:EditText=findViewById(R.id.apellidosRegistro)
        var fechaNacimientoRegistro:EditText=findViewById(R.id.fechaNacimientoRegistro)
        var direccionRegistro:EditText=findViewById(R.id.direccionRegistro)
        var ciudadRegistro:EditText=findViewById(R.id.ciudadRegistro)
        var paisRegistro:EditText=findViewById(R.id.paisRegistro)
        var telefonoRegistro:EditText=findViewById(R.id.telefonoRegistro)
        var usuarioRegistro:EditText=findViewById(R.id.usuarioRegistro)
        var contraseñaRegistro:EditText=findViewById(R.id.contraseñaRegistro)
        var contraseñaComprobacionRegistro:EditText=findViewById(R.id.contraseñaComprobacionRegistro)


        //Guardo los campos recibidos en variables de tipo string
        var nombreRegi: String =nombreRegistro.text.toString()
        var apellidosRegi:String=apellidosRegistro.text.toString()
        var fechaNacimientoRegi:String=fechaNacimientoRegistro.text.toString()
        var direccionRegi:String=direccionRegistro.text.toString()
        var diudadRegi:String=ciudadRegistro.text.toString()
        var paisRegi:String=paisRegistro.text.toString()
        var telefonoRegi:String=telefonoRegistro.text.toString()
        var usuarioRegi:String=usuarioRegistro.text.toString()
        var contraseñaRegi:String=contraseñaRegistro.text.toString()
        var contraseñaComprobacionRegi:String=contraseñaComprobacionRegistro.text.toString()


        //Verificación de datos completados
        if (nombreRegi == "") {

            //Dialogo de alerta que avisa de la acción
            AlertDialog.Builder(this).setTitle("Datos incompletos").setMessage("Falta: nombre").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which -> }).show()

        }else if (apellidosRegi == "") {
            AlertDialog.Builder(this).setTitle("Datos incompletos").setMessage("Falta: apellidos").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which -> }).show()

        }else if (fechaNacimientoRegi == "") {
            AlertDialog.Builder(this).setTitle("Datos incompletos").setMessage("Falta: fecha de nacimiento").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which -> }).show()

        }else if (direccionRegi == "") {
            AlertDialog.Builder(this).setTitle("Datos incompletos").setMessage("Falta: dirección").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which -> }).show()

        }else if (diudadRegi == "") {
            AlertDialog.Builder(this).setTitle("Datos incompletos").setMessage("Falta: ciudad").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which -> }).show()

        }else if (paisRegi == "") {
            AlertDialog.Builder(this).setTitle("Datos incompletos").setMessage("Falta: pais").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which -> }).show()

        }else if (telefonoRegi == "") {
            AlertDialog.Builder(this).setTitle("Datos incompletos").setMessage("Falta: telefono").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which -> }).show()

        }else if (usuarioRegi == "") {
            AlertDialog.Builder(this).setTitle("Datos incompletos").setMessage("Falta: usuario").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which -> }).show()

        }else if (contraseñaRegi == "") {
            AlertDialog.Builder(this).setTitle("Datos incompletos").setMessage("Falta: contraseña").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which -> }).show()

        }else if (contraseñaComprobacionRegi == "") {
            AlertDialog.Builder(this).setTitle("Datos incompletos").setMessage("Falta: comprobación contraseña").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which -> }).show()

        }else{

            //Dialogo de alerta que avisa de la acción
            AlertDialog.Builder(this).setTitle("Registrarse").setMessage("Ir a registrarse").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which ->}).show()

            val intent = Intent(this, Pantalla_Registro::class.java)//Guardo en una variable el Intent
            startActivity(intent)//Iniciamos la actividad
        }

    }















}

























