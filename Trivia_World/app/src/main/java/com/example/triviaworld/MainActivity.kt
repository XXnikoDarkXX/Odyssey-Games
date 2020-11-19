package com.example.triviaworld

import android.Manifest
import android.Manifest.*
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.checkSelfPermission

class MainActivity : AppCompatActivity() {
    companion object val PERMISO_ALMACENAMIENTO=1000;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_principal)
    }

    fun irARedes(view: View) {

        val intent = Intent(this, Pantalla_Redes::class.java)
        startActivity(intent)

    }

    /*fun irAJugar(view: View) {

        val intent = Intent(this, ::class.java)
        startActivity(intent)

    }*/

    fun irAPerfil(view: View) {

        val intent = Intent(this, Pantalla_Perfil::class.java)
        startActivity(intent)

    }

    fun irAOpciones(view: View) {

        val intent = Intent(this, Pantalla_Opciones::class.java)
        startActivity(intent)

    }





}