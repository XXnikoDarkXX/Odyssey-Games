package com.example.triviaworld

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class Pantalla_Login: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_login)

    }

    /**
     *Función para ir a la página de registro, mediante un intent
     */
    fun irARegistrase(view: View) {

        //Dialogo de alerta que avisa de la acción
        AlertDialog.Builder(this).setTitle("Registrarse").setMessage("Ir a registrarse").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which ->}).show()

        val intent = Intent(this, Pantalla_Registro::class.java)//Guardo en una variable el Intent
        startActivity(intent)//Iniciamos la actividad


    }

    /**
     *Función para enviar los datos de email y contraseña
     */
    fun enviar(view: View) {

        //Referencio los campos que voy a utilizar
        var entradaEmail: EditText = findViewById(R.id.mailLogin)
        var entradaContraseña: EditText = findViewById(R.id.contraseñaLogin)

        //Guardo en una variable el email que introduzca el usuario
        //Guardo en una variable la contraseña que introduzca el usuario
        var email: String = entradaEmail.text.toString()
        var contraseña: String = entradaContraseña.text.toString()


        //Verificación de datos completados
        if (email == "") {
            AlertDialog.Builder(this).setTitle("Datos incompletos").setMessage("Falta: email").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which -> }).show()

        }else if (contraseña == "") {
            AlertDialog.Builder(this).setTitle("Datos incompletos").setMessage("Falta: contraseña").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which -> }).show()

        }else{
            AlertDialog.Builder(this).setTitle("Login").setMessage("Logeandose").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which ->}).show()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }




    }



}



/*
        //Guardo la Pantalla ?  o en su caso se enviara a una base de datos, en una variable como tipo Intent, para poder realizar la accion de enviar datos
        //var enviarEmailyContraseña:Intent= Intent(this,Pantalla ? ::class.java)

        //Creacion de bundle y variables referenciadas correspondiente a los campos a introducir en el bundle
        var bundleEmailyContraseña:Bundle= Bundle()//Iniciamos la variable
        var bundleEmail:EditText=findViewById(R.id.mailLogin)//Referenciamos
        var bundleContraseña:EditText=findViewById(R.id.contraseñaLogin)//Referenciamos

        try {
            //Introducimos en el bundle la clave y valor correspondiente al campo email y al campo contraseña
            bundleEmailyContraseña.putString("email", bundleEmail.text.toString())
            bundleEmailyContraseña.putString("contraseña", bundleContraseña.text.toString())

        }catch(e:Exception){
            bundleEmailyContraseña.putString("email","invalido")
            bundleEmailyContraseña.putString("contraseña","invalida")
        }

        //Mediante este metodo metemos a enviarEmailyContraseña que es un Intent el budle: bundleEmailyContraseña
        //enviarEmailyContraseña.putExtras(bundleEmailyContraseña)

        //this.startActivity(enviarEmailyContraseña)//Iniciamos el envio

*/





