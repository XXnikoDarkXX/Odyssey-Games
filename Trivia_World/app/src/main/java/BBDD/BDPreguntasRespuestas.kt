package BBDD

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BDPreguntasRespuestas (val contexto: Context):
        SQLiteOpenHelper(contexto,"BD Preguntas Respuestas ",null,1) {
    companion object {

        //preguntas

        val tablaPreguntas: String = "preguntas"
        val idTablaPreguntas: String = "id"

        val historiaTablaPreguntas: String = "preguntaHistoria"
        val geografiaTablaPreguntas: String = "preguntaGeografia"
        val cienciasTablaPreguntas: String = "preguntaCiencias"
        val arteTablaPreguntas: String = "preguntaArte"
        val entretenimientoTablaPreguntas: String = "preguntaEntretenimiento"


        //respuestas

        val tablaRespuestas1: String = "respuestas1"
        val idTablaRespuestas: String = "id"

        val historiaTablaRespuestas: String = "respuestaHistoria"
        val geografiaTablaRespuestas: String = "respuestaHistoria"
        val cienciasTablaRespuestas: String = "respuestaHistoria"
        val arteTablaRespuestas: String = "respuestaHistoria"
        val entretenimientoTablaRespuestas: String = "respuestaHistoria"
    }

    override fun onCreate(p0: SQLiteDatabase?) {


        /*



        //creación de la tabla preguntas.

        p0?.execSQL("create table $tablaPreguntas("+ idTablaPreguntas+" integer primary key " +
                "autoincrement," +
                "$historiaTablaPreguntas varchar(100), $geografiaTablaPreguntas varchar(100), $cienciasTablaPreguntas varchar(100), $arteTablaPreguntas varchar(100), $entretenimientoTablaPreguntas varchar(100))")

        //primera pregunta de cada categoría

        p0?.execSQL("insert into $tablaPreguntas($historiaTablaPreguntas) values('¿Qué año fueron las cruzadas?')")
        p0?.execSQL("insert into $tablaPreguntas($geografiaTablaPreguntas) values('¿Cuál es la isla más grande del mundo?')")
        p0?.execSQL("insert into $tablaPreguntas($cienciasTablaPreguntas) values('La velocidad a la que viaja la luz es:')")
        p0?.execSQL("insert into $tablaPreguntas($arteTablaPreguntas) values('¿Quién pintó el Guernica?')")
        p0?.execSQL("insert into $tablaPreguntas($entretenimientoTablaPreguntas) values('¿En qué año se estrenó Interestellar?')")


        //creación de la tabla respuestas

        p0?.execSQL("create table $tablaRespuestas1("+ idTablaRespuestas+" integer primary key " +
                "autoincrement," +
                "$historiaTablaRespuestas varchar(100), $geografiaTablaRespuestas varchar(100), $cienciasTablaRespuestas varchar(100), $arteTablaRespuestas varchar(100), $entretenimientoTablaRespuestas varchar(100))")

        //posibles respuestas de cada primera pregunta

        p0?.execSQL("insert into $tablaRespuestas1($historiaTablaRespuestas) values('1189','1095','1075','1187')")

        p0?.execSQL("insert into $tablaRespuestas1($geografiaTablaRespuestas) values('Groenlandia','Australia','Madagascar','Gran Bretaña')")

        p0?.execSQL("insert into $tablaRespuestas1($cienciasTablaRespuestas) values('300.000 m/s','300km/s','30.000km/s','300.000km/s')")

        p0?.execSQL("insert into $tablaRespuestas1($arteTablaRespuestas) values('Vincent van Gogh','Pablo Picasso','Salvador Dalí','Leonardo da Vinci')")

        p0?.execSQL("insert into $tablaRespuestas1($entretenimientoTablaRespuestas) values('2014','2013','2011','2012')")




         */
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}