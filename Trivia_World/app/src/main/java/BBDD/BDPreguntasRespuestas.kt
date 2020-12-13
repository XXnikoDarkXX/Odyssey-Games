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
        var rutag: Int = R.drawable.imagen1_geografia
        var rutac: Int = R.drawable.imagen1_ciencias
        var rutaa: Int = R.drawable.imagen1_arte
        var rutae: Int = R.drawable.imagen1_entretenimiento

        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen) values('¿Qué año fueron las cruzadas?','$ruta')")

        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen) values('¿Cuál es la isla más grande del mundo?','$rutag')")
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen) values('La velocidad a la que viaja la luz es:','$rutac')")
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen) values('¿Quién pintó el Guernica?','$rutaa')")
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen) values('¿En qué año se estrenó Interestellar?','$rutae')")


        //creación de la tabla respuestas

        p0?.execSQL("create table $tablaRespuestas("+ idTablaRespuestas+" integer primary key,"  +
                "$historiaTablaRespuestas varchar(100), $geografiaTablaRespuestas varchar(100), $cienciasTablaRespuestas varchar(100), $arteTablaRespuestas varchar(100), $entretenimientoTablaRespuestas varchar(100))")

        //posibles respuestas de cada primera pregunta


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$historiaTablaRespuestas,$geografiaTablaRespuestas,$cienciasTablaRespuestas,$arteTablaRespuestas,$entretenimientoTablaRespuestas)" +
                " values('101','1189','Groenlandia','300.000m/s','Vincent van Gogh','2014')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$historiaTablaRespuestas,$geografiaTablaRespuestas,$cienciasTablaRespuestas,$arteTablaRespuestas,$entretenimientoTablaRespuestas)" +
                " values('102','1095','Australia','300 km/s','Pablo Picasso','2013')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$historiaTablaRespuestas,$geografiaTablaRespuestas,$cienciasTablaRespuestas,$arteTablaRespuestas,$entretenimientoTablaRespuestas)" +
                " values('103','1075','Madagascar','30.000 km/s','Salvador Dalí','2011')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$historiaTablaRespuestas,$geografiaTablaRespuestas,$cienciasTablaRespuestas,$arteTablaRespuestas,$entretenimientoTablaRespuestas)" +
                " values('104','1187','Gran Bretaña','300.000 km/s','Leonardo da Vinci','2012')")








    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}