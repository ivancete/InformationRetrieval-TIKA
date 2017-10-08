import org.apache.tika.Tika;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


public class practicaTika {

    public static void main(String [] args) throws Exception{
        Tika tika = new Tika();
        // Se parsean los ficheros pasados como argumento y se extrae el contenido

        String directorioDatos = "/Users/Ivanovic/Documents/Recuperacion-Informacion-Tika/datosEntrada/";

        File origen = new File(directorioDatos+"pg29706-images.epub");

        InputStream flujo = new FileInputStream (origen);

        try{
            Metadata metadata = new Metadata ();

            //Le pasamos el -1 para que no nos salte un error de que el fichero sobrepasa el límite de caracteres.
            ContentHandler handler = new BodyContentHandler (-1);

            ParseContext parseContext = new ParseContext ();

            AutoDetectParser parser = new AutoDetectParser ();

            parser.parse ( flujo , handler , metadata , parseContext );

            System.out.println("ch " + handler.toString());

            //Ejemplo de sacar datos pares<clave,valor>.
            for (String name : metadata.names()) {
                String valor = metadata.get(name);
                if (valor != null) {
                    System.out.println("metadata: " + name + " " + valor);
                }
            }

            //Ejemplo de sacar metadatos por su nombre.
            System.out.println("Format: "+metadata.get(Metadata.CONTENT_TYPE));
            System.out.println("Language "+metadata.get("language"));
        }
        finally {

            flujo.close();
        }




    }
}
