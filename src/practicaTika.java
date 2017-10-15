import com.google.common.collect.TreeMultimap;
import org.apache.tika.Tika;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.apache.tika.language.detect.LanguageDetector;
import org.apache.tika.langdetect.OptimaizeLangDetector;
import org.apache.tika.language.detect.LanguageResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;


public class practicaTika {

    public static void main(String [] args) throws Exception{

        Tika tika = new Tika();
        // Se parsean los ficheros pasados como argumento y se extrae el contenido

        String directorioDatos = System.getProperty("user.dir") + "/datosEntrada/";

        System.out.println(directorioDatos);

        File origen = new File(directorioDatos);

        String [] ficheros = origen.list();

        if (ficheros == null){
            return;
        }

        for (String f: ficheros) {

            if(!f.contains(".DS_Store")) {

                InputStream flujo = new FileInputStream(directorioDatos+f);

                try {

                    Metadata metadata = new Metadata();

                    //Le pasamos el -1 para que no nos salte un error de que el fichero sobrepasa el límite de caracteres.
                    ContentHandler handler = new BodyContentHandler(-1);

                    ParseContext parseContext = new ParseContext();

                    AutoDetectParser parser = new AutoDetectParser();

                    parser.parse(flujo, handler, metadata, parseContext);

                    LanguageDetector identifier = new OptimaizeLangDetector().loadModels();

                    LanguageResult idioma = identifier.detect (handler.toString());

                    occurrences occurr = new occurrences(handler);

                    Map<String, Integer> valores = occurr.shortOccurrences();

                    System.out.println("Ocurrencias total de palabras diferentes: "+occurr.getValue());

                    System.out.println("--------------------------------VALORES SIN ORDENADAR------------------------------------------");

                    for (String key : valores.keySet()){

                        System.out.println("Key: "+ key + " Value: "+ valores.get(key));

                    }

                    System.out.println("---------------------------------VALORES ORDENADOS---------------------------");

                    TreeMultimap<Integer,String> valoresOrdenados = occurr.shortedOccurrences();

                    for (Integer key : valoresOrdenados.keySet()){

                        System.out.println("Key: "+ key + " Value: ");

                        Set<String> aux = valoresOrdenados.get(key);

                        for (String cadena : aux){
                            System.out.println(cadena);
                        }

                    }

                    System.out.println("-----------------------------------------------------------------------------");

                    //Ejemplo de sacar metadatos por su nombre.
                    System.out.println("Title: " + metadata.get("title"));
                    System.out.println("Format: " + metadata.get(Metadata.CONTENT_TYPE));
                    System.out.println("Conding: " + metadata.get(Metadata.CONTENT_ENCODING));
                    System.out.println("Language " + metadata.get("language"));
                    System.out.println("Language Detect: " + idioma.getLanguage());
                    System.out.println("-----------------------------------------------------------------------------");

                    return;

                } finally {

                    flujo.close();
                }
            }
        }
    }
}
