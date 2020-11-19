package com.example.triviaworld

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat

class Pantalla_Perfil : AppCompatActivity() {
    companion object val PERMISO_ALMACENAMIENTO=1000; //valor constante que nosotros usamos para identificar esa pedida de permiso
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_perfil)
    }



    /**
     * Funcion para subir una foto
     * Pedimos los permisos de almacenamiento en caso de no nos dara un error
     */
    fun enviarFoto(view: View) {
        //pedimos permiso para poder ejecutar la subida de foto
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this,"Me has concedido permiso", Toast.LENGTH_LONG).show()
        } else {
            //si le doy a permiso en negativo me dara este error
            if (!ActivityCompat.shouldShowRequestPermissionRationale(
                            this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                Toast.makeText(this, R.string.PermisoDenegadoAlmacenamiento, Toast.LENGTH_LONG).show()
            }

            val permisos:Array<String> = arrayOf<String>(Manifest.permission.READ_EXTERNAL_STORAGE)//metemos el permiso a un array de String
            ActivityCompat.requestPermissions(this,permisos,PERMISO_ALMACENAMIENTO)
        }


    }


    override fun onRequestPermissionsResult(requestCode: Int,permissions: Array<out String>,grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==PERMISO_ALMACENAMIENTO){
            if(grantResults.size>0&&grantResults.get(0)== PackageManager.PERMISSION_GRANTED){
                //lanzamos la actividad
            }else{
                //Manejarla como queramos.
                Toast.makeText(this,R.string.almacenamientoDenegado, Toast.LENGTH_LONG).show()
            }
        }

    }

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


}