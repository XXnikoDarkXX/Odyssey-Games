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

        //preguntas historia

        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen, $tipo) values('¿Qué año fueron las cruzadas?','$ruta','historia')")
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen, $tipo) values('¿En que año descubrió Colón América?','$ruta','historia')")
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen, $tipo) values('¿En que isla murió Napoleón?','$ruta','historia')")
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen, $tipo) values('¿En qué año cayó el Imperio Romano de Occidente?','$ruta','historia')")
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen, $tipo) values('¿Cómo se llamó durante más de 50 años San Petersburgo?','$ruta','historia')")

        //preguntas geografia

        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen, $tipo) values('¿Cuál es la isla más grande del mundo?','$rutag', 'geografia')")
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen, $tipo) values('¿En qué país se ubican las ruinas de Esparta?','$rutag', 'geografia')")
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen, $tipo) values('¿Cuál es el rió más largo del mundo?','$rutag', 'geografia')")
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen, $tipo) values('¿Cuántos continentes hay en la Tierra?','$rutag', 'geografia')")
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen, $tipo) values('¿Cuántos océanos hay en la Tierra?','$rutag', 'geografia')")


        //preguntas ciencias

        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen, $tipo) values('La velocidad a la que viaja la luz es:','$rutac', 'ciencias')")
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen, $tipo) values('El sol es:','$rutac', 'ciencias')")
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen, $tipo) values('¿Qué inventó Alfred Nobel?','$rutac', 'ciencias')")
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen, $tipo) values('¿Cuál es la principal función de los globulos rojos?','$rutac', 'ciencias')")
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen, $tipo) values('¿Cómo se llaman las partículas subatómicas con carga eléctrica negativa?','$rutac', 'ciencias')")


        //preguntas arte

        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen, $tipo) values('¿Quién pintó el Guernica?','$rutaa', 'arte')")
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen, $tipo) values('¿En que siglo nació Velázquez?','$rutaa', 'arte')")
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen, $tipo) values('¿En que museo está la Mona Lisa?','$rutaa', 'arte')")
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen, $tipo) values('¿Cuándo nació Goya?','$rutaa', 'arte')")
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen, $tipo) values('¿Cuál de estas no es una de las 7 maravillas del mundo antiguo?','$rutaa', 'arte')")


        //preguntas entretenimiento


        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen, $tipo) values('¿En qué año se estrenó Interestellar?','$rutae', 'entretenimiento')")
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen, $tipo) values('¿Quién es la mascota de SEGA?','$rutae', 'entretenimiento')")
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen, $tipo) values('¿Cómo se llama el pájaro símbolo de los Juegos del Hambre?','$rutae', 'entretenimiento')")
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen, $tipo) values('¿Cuál es el nombre del sistema informático (IA) en videojuego Portal?','$rutae', 'entretenimiento')")
        p0?.execSQL("insert into $tablaPreguntas($Pregunta, $Imagen, $tipo) values('¿En qué video juego aparece el mob Murloc?','$rutae', 'entretenimiento')")


        //creación de la tabla respuestas

        p0?.execSQL("create table $tablaRespuestas("+ idTablaRespuestas+" integer primary key,"  +
                "$respuesta varchar(100), $tipo varchar(100))")

        //posibles respuestas de cada primera pregunta

        //primera pregunta historia

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('101','1189','historia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('102','1095','historia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('103','1075','historia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('104','1187','historia')")

        //segunda pregunta historia


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('201','1492','historia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('202','1502','historia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('203','1496','historia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('204','1488','historia')")

        //tercera pregunta historia


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('301','Cerdeña','historia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('302','Elba','historia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('303','Santa Elena','historia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('304','Corcega','historia')")


        //cuarta pregunta historia


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('401','456','historia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('402','496','historia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('403','501','historia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('404','476','historia')")


        //quinta pregunta historia


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('501','Petroburgo','historia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('502','Lenningrado','historia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('503','Trotskigrado','historia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('504','Stalingrado','historia')")


        //primera pregunta geografia


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('601','Groenlandia','geografia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('602','Australia','geografia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('603','Madagascar','geografia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('604','Gran Bretaña','geografia')")

        //segunda pregunta geografia


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('701','España','geografia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('702','Italia','geografia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('703','Grecia','geografia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('704','Egipto','geografia')")

        //tercera pregunta geografia


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('801','Río Tajo','geografia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('802','Río Amarillo','geografia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('803','Nilo','geografia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('804','Amazonas','geografia')")

        //cuarta pregunta geografia


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('901','5','geografia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('902','6','geografia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('903','7','geografia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('904','8','geografia')")

        //quinta pregunta geografia


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('1001','5','geografia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('1002','6','geografia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('1003','11','geografia')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('1004','7','geografia')")

        //primera pregunta ciencias


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('1101','300.000 m/s','ciencias')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('1102','300 km/s','ciencias')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('1103','30.000 km/s','ciencias')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('1104','300.000 km/s','ciencias')")


        //segunda pregunta ciencias


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('1201','Un planeta','ciencias')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('1202','Una estrella','ciencias')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('1203','Un satélite','ciencias')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('1204','Un meteorito','ciencias')")

        //tercera pregunta ciencias


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('1301','La dinamita','ciencias')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('1302','La penicilina','ciencias')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('1303','La bomba atómica','ciencias')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('1304','La electricidad','ciencias')")

        //cuarta pregunta ciencias


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('1401','Combatir enfermedades','ciencias')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('1402','Coagular la sangre','ciencias')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('1403','Llevar Oxígeno','ciencias')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('1404','Ninguna de las anteriores','ciencias')")

        //quinta pregunta ciencias


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('1501','Electrones','ciencias')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('1502','Protones','ciencias')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('1503','Neutrones','ciencias')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('1504','Citrones','ciencias')")


        //primera pregunta arte


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('1601','Vincent van Gogh','arte')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('1602','Pablo Picasso','arte')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('1603','Salvador Dalí','arte')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('1604','Leonardo da Vinci','arte')")


        //segunda pregunta arte


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('1701','Siglo XVII','arte')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('1702','Siglo XVIII','arte')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('1703','Siglo XV','arte')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('1704','Siglo XVI','arte')")


        //tercera pregunta arte


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('1801','Museo del Prado','arte')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('1802','British Museum','arte')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('1803','Louvre','arte')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('1804','Galería Uffizi','arte')")

        //cuarta pregunta arte


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('1901','1706','arte')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('1902','1796','arte')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('1903','1806','arte')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('1904','1746','arte')")


        //quinta pregunta arte


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('2001','Templo de Artemisa','arte')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('2002','Gran Pirámide de Giza','arte')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('2003','Faro de Alejandría','arte')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('2004','Partenon','arte')")

        //primera pregunta entretenimiento


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('2101','2014','entretenimiento')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('2102','2013','entretenimiento')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('2103','2011','entretenimiento')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('2104','2012','entretenimiento')")


        //segunda pregunta entretenimiento


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('2201','Sonic','entretenimiento')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('2202','Mario','entretenimiento')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('2203','Pac Man','entretenimiento')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('2204','El caballo Juan','entretenimiento')")

        //tercera pregunta entretenimiento


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('2301','Lechuza','entretenimiento')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('2302','Sinsajo','entretenimiento')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('2303','Gale','entretenimiento')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('2304','Llamas','entretenimiento')")

        //cuarta pregunta entretenimiento


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('2401','Cortana','entretenimiento')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('2402','Mastocito','entretenimiento')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('2403','Chell','entretenimiento')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('2404','GLaDOS','entretenimiento')")


        //quinta pregunta entretenimiento


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('2501','The Legend of Juan','entretenimiento')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('2502','El fontanero Bros','entretenimiento')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo)" +
                " values('2503','World of Warcraft','entretenimiento')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo)" +
                " values('2504','Maincra','entretenimiento')")


    }




    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}