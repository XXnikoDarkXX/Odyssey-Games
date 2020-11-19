package com.example.triviaworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_principal)
    }

    fun irARedes(view: View) {

        val intent = Intent(this, Pantalla_Redes::class.java)
        startActivity(intent)

    }




}