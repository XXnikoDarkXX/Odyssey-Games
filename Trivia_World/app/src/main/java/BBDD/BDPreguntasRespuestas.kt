package BBDD

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.triviaworld.R

class BDPreguntasRespuestas (val contexto: Context):
        SQLiteOpenHelper(contexto,"BD Preguntas Respuestas ",null,1) {
    companion object {

        //preguntas

        val tablaPreguntas: String = "preguntas"
        val idTablaPreguntas: String = "id"

        val Pregunta: String = "pregunta"
        val Imagen: String = "imagen"
        val tipo: String = "tipo"
        /*val geografiaTablaPreguntas: String = "preguntaGeografia"
        val cienciasTablaPreguntas: String = "preguntaCiencias"
        val arteTablaPreguntas: String = "preguntaArte"
        val entretenimientoTablaPreguntas: String = "preguntaEntretenimiento"*/


        //respuestas

        val tablaRespuestas: String = "respuestas"
        val idTablaRespuestas: String = "id"

        val respuesta: String = "respuesta"
        /*val geografiaTablaRespuestas: String = "respuestaGeografia"
        val cienciasTablaRespuestas: String = "respuestaCiencias"
        val arteTablaRespuestas: String = "respuestaArte"
        val entretenimientoTablaRespuestas: String = "respuestaEntretenimiento"*/
    }

    override fun onCreate(p0: SQLiteDatabase?) {


        //creación de la tabla preguntas.

        p0?.execSQL("create table $tablaPreguntas("+ idTablaPreguntas+" integer primary key " +"autoincrement," +
                "$Pregunta varchar(100), $Imagen integer, $tipo varchar(100))")

        //primera pregunta de cada categoría

        var ruta: Int = R.drawable.imagen_prueba
        var rutag: Int = R.drawable.imagen1_geografia
        var rutac: Int = R.drawable.imagen1_ciencias
        var rutaa: Int = R.drawable.imagen1_arte
        var rutae: Int = R.drawable.imagen1_entretenimiento

        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen, $tipo) values('¿Qué año fueron las cruzadas?','$ruta','historia')")
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen, $tipo) values('¿Quien es mayor?','$rutac','historia')")

        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen, $tipo) values('¿Cuál es la isla más grande del mundo?','$rutag', 'geografia')")
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen, $tipo) values('La velocidad a la que viaja la luz es:','$rutac', 'geografia')")
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen, $tipo) values('¿Quién pintó el Guernica?','$rutaa', 'geografia')")
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen, $tipo) values('¿En qué año se estrenó Interestellar?','$rutae', 'geografia')")


        //creación de la tabla respuestas

        p0?.execSQL("create table $tablaRespuestas("+ idTablaRespuestas+" integer primary key,"  +
                "$respuesta varchar(100), $tipo varchar(100))")

        //posibles respuestas de cada primera pregunta


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('101','1189','historia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('102','1095','historia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('103','1075','historia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('104','1187','historia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('201','tu pae','historia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('202','el mio','historia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('203','el de Juanlu','historia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('204','El del revolvero','historia')")


    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}