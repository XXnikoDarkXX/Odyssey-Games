package BBDD

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BDPersona (val contexto:Context) : SQLiteOpenHelper(contexto,"BD Persona",null,1){

    companion object{//variables estaticas
        val tablaPersona:String = "persona"
        val idPersona:String= "id"
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

    /**
     * Como se crea la base de datos
     * No tenemos q llamarla, se ejecuta automaticamente cuando vas a usar por primera vez la base de datos
     * Solo una vez
     */
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table $tablaPersona("+idPersona+" integer primary key autoincrement, $nombre varchar(100),"+
                "$apellidos varchar(100), $fechaNacimiento varchar(100), $direccion varchar(100), $ciudad varchar(100)," +
                "$pais varchar(100),$telefono varchar(100),$usuario varchar(100),$contraseña varchar(100))")

        db?.execSQL("insert into $tablaPersona($idPersona,$nombre,$apellidos,$fechaNacimiento,$direccion," +
                "$ciudad,$pais,$telefono,$usuario,$contraseña) values('1','OjoLoco','Pino','15/3/1980','calle sin salida'," +
                "'Nerverland','españa','12345678','admin','0000')")
    }

    /**
     * Como se actualiza la base de datos
     * Hay que meter los cambios respecto a la version anterior (se ejecuta cuando detecta cambio en el numero de la version)
     */
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}