package com.example.triviaworld

import BBDD.BDPersona
import Clases.Persona
import android.content.DialogInterface
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class Pantalla_Login: AppCompatActivity() {

    val database: SQLiteDatabase by lazy{ BDPersona(this).writableDatabase }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_login)

    }

    /**
     * Función para ir a la página de inicio pulsando el logo, mediante un intent
     */
    fun volverInicio(view: View) {

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
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
        var entradaUsuarioLogin: EditText = findViewById(R.id.usuarioLoginIn)
        var entradaContraseña: EditText = findViewById(R.id.contraseñaLogin)

        //Guardo en una variable el email que introduzca el usuario
        //Guardo en una variable la contraseña que introduzca el usuario
        var email: String = entradaUsuarioLogin.text.toString()
        var contraseña: String = entradaContraseña.text.toString()


        //Verificación de datos completados
        if (email == "") {
            AlertDialog.Builder(this).setTitle("Datos incompletos").setMessage("Falta: usuario").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which -> }).show()

        }else if (contraseña == "") {
            AlertDialog.Builder(this).setTitle("Datos incompletos").setMessage("Falta: contraseña").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which -> }).show()

        }else{
            AlertDialog.Builder(this).setTitle("Login").setMessage("Logeandose").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which ->}).show()

            val intent = Intent(this, Pantalla_Perfil::class.java)
            startActivity(intent)


            //enviarAPerfil()
        }




    }

    /**
     *
     */
    fun enviarAPerfil(){//EQUIVALE A UN SELECT

        val personas:ArrayList<Persona> = arrayListOf<Persona>()

        /**
         * query:es la q hace las consultas
         * Constructor:
         * Nombre de la tabla,
         * Columnas - null       las columnas(Array<String> y la ponemos a null, para q las seleccione todas),
         * Selection - null      Lo mismo q pondria en un where pero sin poner la palabra where(en este caso no vamos a poner nada, pues null),
         * SelectionArgs - null  Por si queremos poner interrogaciones,
         * Group by - null
         * Having - null
         * Order by - Tema5OpenHelper.idTablaUsuario+" desc", para ordernar en orden descendente
         */
        //Cuando se usa el order by, hay q guardarlo en una variable de tipo Cursor
        var cursor: Cursor =database.query(BDPersona.tablaPersona,null,null,
                null,null,null, BDPersona.usuario+" asc")

        cursor.moveToFirst()//ponerlo en la primera
        while(!cursor.isAfterLast){//mientras q no ocurra q curso este despues del ultimo
            val idUsuario:Int=cursor.getInt(cursor.getColumnIndex(BDPersona.idPersona))//para no acordarnos del nombre de la columna,
            val nombre:String=cursor.getString(cursor.getColumnIndex(BDPersona.nombre))//utilizamos esta forma,
            val apellidos:String=cursor.getString(cursor.getColumnIndex(BDPersona.apellidos))//lo q hay entre los (...)
            val fechaNacimiento:String=cursor.getString(cursor.getColumnIndex(BDPersona.fechaNacimiento))
            val direccion:String=cursor.getString(cursor.getColumnIndex(BDPersona.direccion))
            val ciudad:String=cursor.getString(cursor.getColumnIndex(BDPersona.ciudad))
            val pais:String=cursor.getString(cursor.getColumnIndex(BDPersona.pais))
            val telefono:String=cursor.getString(cursor.getColumnIndex(BDPersona.telefono))
            val usuario:String=cursor.getString(cursor.getColumnIndex(BDPersona.usuario))
            val contraseña:String=cursor.getString(cursor.getColumnIndex(BDPersona.contraseña))

            //metemos en el ArrayList personas de tipo Persona, el objeto de tipo Persona con los valores obtenidos
            personas.add(Persona(idUsuario, nombre, apellidos, fechaNacimiento, direccion, ciudad, pais, telefono, usuario, contraseña))

            cursor.moveToNext()//para q vaya a la siguiente fila, hasta esta linea estaba iterando por las columnas
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





