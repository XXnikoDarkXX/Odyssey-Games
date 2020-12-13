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
        val geografiaTablaPreguntas: String = "preguntaGeografia"
        val cienciasTablaPreguntas: String = "preguntaCiencias"
        val arteTablaPreguntas: String = "preguntaArte"
        val entretenimientoTablaPreguntas: String = "preguntaEntretenimiento"


        //respuestas

        val tablaRespuestas: String = "respuestas"
        val idTablaRespuestas: String = "id"

        val historiaTablaRespuestas: String = "respuestaHistoria"
        val geografiaTablaRespuestas: String = "respuestaGeografia"
        val cienciasTablaRespuestas: String = "respuestaCiencias"
        val arteTablaRespuestas: String = "respuestaArte"
        val entretenimientoTablaRespuestas: String = "respuestaEntretenimiento"
    }

    override fun onCreate(p0: SQLiteDatabase?) {


        //creación de la tabla preguntas.

        p0?.execSQL("create table $tablaPreguntas("+ idTablaPreguntas+" integer primary key " +
                "autoincrement," +
                "$Pregunta varchar(100), $Imagen integer)")

        //primera pregunta de cada categoría

        var ruta: Int = R.drawable.imagen_prueba
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen) values('¿Qué año fueron las cruzadas?','$ruta')")
        var rutag: Int = R.drawable.imagen1_geografia
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen) values('¿Cuál es la isla más grande del mundo?','$rutag')")
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen) values('La velocidad a la que viaja la luz es:','2')")
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen) values('¿Quién pintó el Guernica?','2')")
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen) values('¿En qué año se estrenó Interestellar?','2')")


        //creación de la tabla respuestas

        p0?.execSQL("create table $tablaRespuestas("+ idTablaRespuestas+" integer primary key,"  +
                "$historiaTablaRespuestas varchar(100), $geografiaTablaRespuestas varchar(100), $cienciasTablaRespuestas varchar(100), $arteTablaRespuestas varchar(100), $entretenimientoTablaRespuestas varchar(100))")

        //posibles respuestas de cada primera pregunta


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$historiaTablaRespuestas) values('101','1189')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$historiaTablaRespuestas) values('102','1095')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$historiaTablaRespuestas) values('103','1075')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$historiaTablaRespuestas) values('104','1187')")


        /*
        p0?.execSQL("insert into $tablaRespuestas($geografiaTablaRespuestas) values('Groenlandia','Australia','Madagascar','Gran Bretaña')")

        p0?.execSQL("insert into $tablaRespuestas($cienciasTablaRespuestas) values('300.000 m/s','300km/s','30.000km/s','300.000km/s')")

        p0?.execSQL("insert into $tablaRespuestas($arteTablaRespuestas) values('Vincent van Gogh','Pablo Picasso','Salvador Dalí','Leonardo da Vinci')")

        p0?.execSQL("insert into $tablaRespuestas($entretenimientoTablaRespuestas) values('2014','2013','2011','2012')")
        */




    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}