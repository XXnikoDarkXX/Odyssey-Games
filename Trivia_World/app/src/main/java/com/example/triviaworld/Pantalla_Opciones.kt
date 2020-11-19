package com.example.triviaworld

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
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

    /**
     * Funcion para cambiar contraseña
     * En caso de que no se rellene algun campo se validará y dará una alerta
     */
    fun cambiaPass(view: View) {
        //voy a realizar la validacion de campos
        var user: EditText =findViewById(R.id.cambioUsuario)
        var contraseñaAntigua: EditText =findViewById(R.id.passAntigua)
        var contraseñaActual: EditText =findViewById(R.id.passNueva)

        if (user.text.toString().equals("")||contraseñaActual.text.toString().equals("")||contraseñaAntigua.text.toString().equals("")){
            android.app.AlertDialog.Builder(this)
                    .setTitle("Cambio de contraseña")
                    .setMessage("Hay un campo que no tienes rellenado")
                    .setPositiveButton(android.R.string.ok,
                            DialogInterface.OnClickListener { dialog, which ->
                                //botón OK pulsado
                            })

                    .show()
        }else {

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
}