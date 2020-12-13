package com.example.triviaworld

import BBDD.BDPersona
import Clases.Persona
import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import org.w3c.dom.Text

class Pantalla_Perfil : AppCompatActivity() {

    val REQUEST_CODE = 200
   companion object{
        val PERMISO_ALMACENAMIENTO=1000;     //valor constante que nosotros usamos para identificar esa pedida de permiso
         var comprobacionNombreUsuario:String=""

   }
   val database: SQLiteDatabase by lazy { BDPersona(this).writableDatabase }
    var personas: ArrayList<Persona> = ArrayList<Persona>()//ArrayList de todos las personas
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_perfil)
        lateinit var currentPhotoPath: String

        var bundle: Bundle? =this.intent.extras
        val usuario:String?= bundle?.getString("usuario")
        var campoUsuario:TextView=findViewById<TextView>(R.id.txtUsuario)
        var campoNombre:TextView=findViewById<TextView>(R.id.nombre)

        refrecarUsuarios()
        var contador:Int=0
        if (usuario!=null){
            comprobacionNombreUsuario=usuario
        }

        if (personas.size>0&&!(comprobacionNombreUsuario.equals(""))) {
            while (contador < personas.size) {
                if (personas.get(contador).usuario.equals(comprobacionNombreUsuario)) {
                    campoUsuario.setText(personas.get(contador).usuario)
                    campoNombre.setText(personas.get(contador).nombre)
                }
                contador++

            }


        }


    }



   /*
     * Funcion para subir una foto
     * Pedimos los permisos de almacenamiento en caso de no nos dara un error
     */
    fun enviarFoto(view: View) {
        if (pedirPermisos()==true) {
            capturePhoto()

        }



    }


    /*  override fun onRequestPermissionsResult(requestCode: Int,permissions: Array<out String>,grantResults: IntArray) {
          super.onRequestPermissionsResult(requestCode, permissions, grantResults)
          if(requestCode==PERMISO_ALMACENAMIENTO){
              if(grantResults.size>0&&grantResults.get(0)== PackageManager.PERMISSION_GRANTED){
                  //lanzamos la actividad
              }else{
                  //Manejarla como queramos.
                  Toast.makeText(this,R.string.permisoDenegado, Toast.LENGTH_LONG).show()
              }
          }

      }*/

    /**
     * Funcion para ir a la actividad Principal
     */
    fun irAInicio(view: View) {

        var intent: Intent = Intent(this, MainActivity::class.java)
        this.startActivity(intent)

    }

    /**
     * Funcion para ir a la actividad login
     */
    fun irALogin(view: View) {
        var intent: Intent = Intent(this, Pantalla_Login::class.java)
        this.startActivity(intent)

    }


    fun pedirPermisos():Boolean{

        //pedimos permiso para poder ejecutar la subida de foto
        var comprobacionAlmacenamiento:Boolean
        var comprobacionCamara:Boolean


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this,R.string.permisoAceptado, Toast.LENGTH_LONG).show()
            comprobacionAlmacenamiento=true
        } else {
            //si le doy a permiso en negativo me dara este error
            if (!ActivityCompat.shouldShowRequestPermissionRationale(
                            this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                Toast.makeText(this, R.string.permisoDenegado, Toast.LENGTH_LONG).show()

            }

            val permisos:Array<String> = arrayOf<String>(Manifest.permission.READ_EXTERNAL_STORAGE)//metemos el permiso a un array de String
            ActivityCompat.requestPermissions(this,permisos,PERMISO_ALMACENAMIENTO)
            comprobacionAlmacenamiento=false
        }


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED ){
            comprobacionCamara=true
        }else{
            if (!ActivityCompat.shouldShowRequestPermissionRationale(
                            this,Manifest.permission.CAMERA)) {
                Toast.makeText(this,R.string.permisoDenegado,
                        Toast.LENGTH_LONG).show()

            }
            val permisos:Array<String> = arrayOf<String>(Manifest.permission.CAMERA);
            ActivityCompat.requestPermissions(this,permisos,PERMISO_ALMACENAMIENTO)
            comprobacionCamara=false
        }
        if (comprobacionAlmacenamiento==true&&comprobacionCamara==true){
            return true
        }
        return false
    }

    fun capturePhoto() {

        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, REQUEST_CODE)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        var foto: ImageView = findViewById(R.id.avatar)

        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE && data != null){
            foto.setImageBitmap(data.extras?.get("data") as Bitmap)
        }
    }


    /**
     * Funcion para obtener en un arrayList todos los usuarios actualizados de la bbdd
     */
    fun refrecarUsuarios(){

        var todos :ArrayList<Persona> = ArrayList<Persona>()

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

            todos.add(Persona(personaId,personaNombre, personaApellidos, fechaDeNacimiento, personaDireccion, personaCiudad, personaPais, personaTelefono,
                    personaUsuario, personaContraseña))

            cursor.moveToNext()

        }

        personas=todos


    }



}