package com.example.triviaworld

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class Pantalla_Opciones : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_opciones)
    }

    fun irAInicio(view: View) {
        var intent:Intent= Intent(this, MainActivity::class.java)
        this.startActivity(intent)

    }

    fun cambiaPass(view: View) {



        android.app.AlertDialog.Builder(this)
                .setTitle("Cambio de contraseña")
                .setMessage("Has cambiado la contraseña")
                .setPositiveButton(android.R.string.ok,
                        DialogInterface.OnClickListener { dialog, which ->
                            //botón OK pulsado
                        })

                .show()

    }
}