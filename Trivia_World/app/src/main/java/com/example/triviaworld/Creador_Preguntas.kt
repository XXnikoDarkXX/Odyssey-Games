package com.example.triviaworld

import android.Manifest
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class Creador_Preguntas : AppCompatActivity() {
    companion object val PERMISO_ALMACENAMIENTO=1000;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.creador__preguntas)
    }
    //subirImagen

    fun subirImagen(view: View) {

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


}