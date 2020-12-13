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

    //Permite usar la base de datos en la actividad actual, tipo, lazy, la clase creada con accseso al constructor mediante el contexto y escribir en ella
    val database: SQLiteDatabase by lazy{ BDPersona(this).writableDatabase }

    //variable en la q se guarda toda la base de datos q se actualizara cada vez q se llama a actualizarPersona
    var personas: ArrayList<Persona> = ArrayList<Persona>()

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

        //Guardo en una variable el usuario que introduze el usuario
        //Guardo en una variable la contraseña que introduze el usuario
        var usuario: String = entradaUsuarioLogin.text.toString()
        var contraseña: String = entradaContraseña.text.toString()


        //Verificación de datos completados
        if (usuario == "") {
            AlertDialog.Builder(this).setTitle("Datos incompletos").setMessage("Falta: usuario").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which -> }).show()

        }else if (contraseña == "") {
            AlertDialog.Builder(this).setTitle("Datos incompletos").setMessage("Falta: contraseña").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which -> }).show()

        }else{

            actualizarPersona()//llamo a la funcion para q la variable personas este actualizada y hacer las comprobaciones

            //Verificacion para q el usuario y su contraseña coincidan con el de la base de datos
            var contador=0
            var comprobacion:Boolean=false//se utiliza para en caso de no haber coincidencia en usuario y contraseña, salta un alertDialog
            while(contador<personas.size) {
                if (personas.get(contador).usuario.equals(usuario) && personas.get(contador).contraseña.equals(contraseña)) {

                    //ENVIO DE DATOS A PANTALLA PERFIL
                    var intent:Intent=Intent(this,Pantalla_Perfil::class.java)
                    var bun:Bundle=Bundle()

                    var usuario:EditText=findViewById(R.id.usuarioLoginIn)
                    //var contraseña:EditText=findViewById(R.id.contraseñaLogin)

                    bun.putString("usuario",usuario.text.toString())
                    //bun.putShort("contraseña", contraseña.text.toString().toShort())

                    AlertDialog.Builder(this).setTitle("Login").setMessage("Logeandose").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which ->}).show()

                    comprobacion=true

                    intent.putExtras(bun)
                    this.startActivity(intent)

                }
                contador++
            }

            if (comprobacion==false){
                AlertDialog.Builder(this).setTitle("Login").setMessage("Error usuario o contraseña").setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which ->}).show()
            }

        }

    }

    /**
     *
     */
    fun actualizarPersona(){//EQUIVALE A UN SELECT

        var todos :ArrayList<Persona> = ArrayList<Persona>()

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

        cursor.moveToFirst()//movemos el cursos al primer registro
        while(!cursor.isAfterLast){//mientras q no ocurra q curso este despues del ultimo
            val personaId:Int=cursor.getInt(cursor.getColumnIndex(BDPersona.idPersona))//para no acordarnos del nombre de la columna,
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
            todos.add(Persona(personaId, nombre, apellidos, fechaNacimiento, direccion, ciudad, pais, telefono, usuario, contraseña))

            cursor.moveToNext()//para q vaya a la siguiente fila, hasta esta linea estaba iterando por las columnas
        }

        //cada vez q se ejecute esta funcion actualizara a -personas- con los datos obtenidos en -todos-
        personas=todos

    }

}








