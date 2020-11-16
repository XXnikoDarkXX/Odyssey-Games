package com.example.triviaworld

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Pantalla_Login: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_login)


    }


    fun enviar(view: View) {

        //Guardo la PantallaInicio en una variable como tipo Intent, para poder realizar la accion de enviar datos
        //var enviarEmailyContraseña:Intent= Intent(this,PantallaInicio::class.java)

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





    }

}