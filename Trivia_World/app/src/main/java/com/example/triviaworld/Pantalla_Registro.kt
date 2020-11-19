package com.example.triviaworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class Pantalla_Registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_registro)
    }

    fun enviarRegistro(view: View) {

        //Guardo la Pantalla ?  o en su caso se enviara a una base de datos, en una variable como tipo Intent, para poder realizar la accion de enviar datos
        //var enviarRegistro:Intent= Intent(this,Pantalla ? ::class.java)

        //Inicializo la variable bundle
        var bundleDatosRegistro:Bundle= Bundle()

        //Referenciamos los diferentes campos de datos
        var bundelNombreRegi: EditText =findViewById(R.id.nombreRegistro)
        var bundleApellidosRegi:EditText=findViewById(R.id.apellidosRegistro)
        var bundlefechaNacimientoRegi:EditText=findViewById(R.id.fechaNacimientoRegistro)
        var bundledireccionRegi:EditText=findViewById(R.id.direccionRegistro)
        var bundleciudadRegi:EditText=findViewById(R.id.ciudadRegistro)
        var bundlepaisRegi:EditText=findViewById(R.id.paisRegistro)
        var bundletelefonoRegi:EditText=findViewById(R.id.telefonoRegistro)
        var bundleusuarioRegi:EditText=findViewById(R.id.usuarioRegistro)
        var bundlecontraseñaRegi:EditText=findViewById(R.id.contraseñaRegistro)
        var bundlecontraseñaComprobacionRegi:EditText=findViewById(R.id.contraseñaComprobacionRegistro)


        try {


        }catch (e:Exception){

        }

    }


}






















