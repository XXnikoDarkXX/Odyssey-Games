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
        val preguntaCorrecta = "preguntacorrecta"
        /*val geografiaTablaPreguntas: String = "preguntaGeografia"
        val cienciasTablaPreguntas: String = "preguntaCiencias"
        val arteTablaPreguntas: String = "preguntaArte"
        val entretenimientoTablaPreguntas: String = "preguntaEntretenimiento"*/


        //respuestas

        val tablaRespuestas: String = "respuestas"
        val idTablaRespuestas: String = "id"

        val respuesta: String = "respuesta"
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
                "$respuesta varchar(100), $tipo varchar(100), $preguntaCorrecta varchar(100))")

        //posibles respuestas de cada primera pregunta

        //primera pregunta historia

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('101','1189','historia','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('102','1095','historia','correcta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('103','1075','historia','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('104','1187','historia','incorrecta')")

        //segunda pregunta historia


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('201','1492','historia','correcta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('202','1502','historia','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('203','1496','historia','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('204','1488','historia','incorrecta')")

        //tercera pregunta historia


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('301','Cerdeña','historia','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('302','Elba','historia','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('303','Santa Elena','historia','correcta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('304','Corcega','historia','incorrecta')")


        //cuarta pregunta historia


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('401','456','historia','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('402','496','historia','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('403','501','historia','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('404','476','historia','correcta')")


        //quinta pregunta historia


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('501','Petroburgo','historia','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('502','Lenningrado','historia','correcta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('503','Trotskigrado','historia','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('504','Stalingrado','historia','incorrecta')")


        //primera pregunta geografia


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('601','Groenlandia','geografia','correcta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('602','Australia','geografia','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('603','Madagascar','geografia','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('604','Gran Bretaña','geografia','incorrecta')")

        //segunda pregunta geografia


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('701','España','geografia','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('702','Italia','geografia','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('703','Grecia','geografia','correcta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('704','Egipto','geografia','incorrecta')")

        //tercera pregunta geografia


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('801','Río Tajo','geografia','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('802','Río Amarillo','geografia','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('803','Nilo','geografia','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('804','Amazonas','geografia','correcta')")

        //cuarta pregunta geografia


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('901','5','geografia','correcta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('902','6','geografia','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('903','7','geografia','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('904','8','geografia','incorrecta')")

        //quinta pregunta geografia


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('1001','5','geografia','correcta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('1002','6','geografia','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('1003','11','geografia','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('1004','7','geografia','incorrecta')")

        //primera pregunta ciencias


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('1101','300.000 m/s','ciencias','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('1102','300 km/s','ciencias','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('1103','30.000 km/s','ciencias','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('1104','300.000 km/s','ciencias','correcta')")


        //segunda pregunta ciencias


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('1201','Un planeta','ciencias','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('1202','Una estrella','ciencias','correcta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('1203','Un satélite','ciencias','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('1204','Un meteorito','ciencias','incorrecta')")

        //tercera pregunta ciencias


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('1301','La dinamita','ciencias','correcta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('1302','La penicilina','ciencias','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('1303','La bomba atómica','ciencias','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('1304','La electricidad','ciencias','incorrecta')")

        //cuarta pregunta ciencias


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('1401','Combatir enfermedades','ciencias','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('1402','Coagular la sangre','ciencias','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('1403','Llevar Oxígeno','ciencias','correcta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('1404','Ninguna de las anteriores','ciencias','incorrecta')")

        //quinta pregunta ciencias


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('1501','Electrones','ciencias','correcta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('1502','Protones','ciencias','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('1503','Neutrones','ciencias','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('1504','Citrones','ciencias','incorrecta')")


        //primera pregunta arte


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('1601','Vincent van Gogh','arte','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('1602','Pablo Picasso','arte','correcta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('1603','Salvador Dalí','arte','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('1604','Leonardo da Vinci','arte','incorrecta')")


        //segunda pregunta arte


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('1701','Siglo XVII','arte','correcta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('1702','Siglo XVIII','arte','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('1703','Siglo XV','arte','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('1704','Siglo XVI','arte','incorrecta')")


        //tercera pregunta arte


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('1801','Museo del Prado','arte','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('1802','British Museum','arte','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('1803','Louvre','arte','correcta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('1804','Galería Uffizi','arte','incorrecta')")

        //cuarta pregunta arte


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('1901','1706','arte','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('1902','1796','arte','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('1903','1806','arte','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('1904','1746','arte','correcta')")


        //quinta pregunta arte


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('2001','Templo de Artemisa','arte','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('2002','Gran Pirámide de Giza','arte','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('2003','Faro de Alejandría','arte','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('2004','Partenon','arte','correcta')")

        //primera pregunta entretenimiento


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('2101','2014','entretenimiento','correcta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('2102','2013','entretenimiento','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('2103','2011','entretenimiento','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('2104','2012','entretenimiento','incorrecta')")


        //segunda pregunta entretenimiento


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('2201','Sonic','entretenimiento','correcta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('2202','Mario','entretenimiento','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('2203','Pac Man','entretenimiento','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('2204','El caballo Juan','entretenimiento','incorrecta')")

        //tercera pregunta entretenimiento


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('2301','Lechuza','entretenimiento','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('2302','Sinsajo','entretenimiento','correcta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('2303','Gale','entretenimiento','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('2304','Llamas','entretenimiento','incorrecta')")

        //cuarta pregunta entretenimiento


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('2401','Cortana','entretenimiento','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('2402','Mastocito','entretenimiento','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('2403','Chell','entretenimiento','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('2404','GLaDOS','entretenimiento','correcta')")


        //quinta pregunta entretenimiento


        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('2501','The Legend of Juan','entretenimiento','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('2502','El fontanero Bros','entretenimiento','incorrecta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas, $respuesta, $tipo, $preguntaCorrecta)" +
                " values('2503','World of Warcraft','entretenimiento','correcta')")

        p0?.execSQL("insert into $tablaRespuestas($idTablaRespuestas,$respuesta, $tipo, $preguntaCorrecta)" +
                " values('2504','Maincra','entretenimiento','incorrecta')")


    }




    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}