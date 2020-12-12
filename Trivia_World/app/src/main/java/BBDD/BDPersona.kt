package BBDD

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BDPersona (val contexto:Context) : SQLiteOpenHelper(contexto,"BD Persona",null,1){

    companion object{
        val tablaPersona:String = "persona"
        val nombre:String = "nombre"
        val apellidos:String="apellidos"
        val fechaNacimiento:String="fechaNacimiento"
        val direccion:String="direccion"
        val ciudad:String="ciudad"
        val pais:String="pais"
        val telefono:String="telefono"
        val usuario:String="usuario"
        val contraseña:String="contraseña"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table $tablaPersona("+usuario+" varchar(100) primary key, "+"$nombre varchar(100),"+
                "$apellidos varchar(100),"+"$fechaNacimiento varchar(100),"+"$direccion varchar(100),"+"$ciudad varchar(100),+" +
                "$pais varchar(100),"+"$telefono varchar(100),"+"$contraseña varchar(100))")

        db?.execSQL("insert into $tablaPersona($usuario,$nombre,$apellidos,$fechaNacimiento,$direccion," +
                "$ciudad,$pais,$telefono,$contraseña) values('admin','OjoLoco','Pino','15/3/1980','calle sin salida'," +
                "'Nerverland','12345678','0000')")
    }



    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}