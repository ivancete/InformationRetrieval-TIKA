import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.html.HtmlParser;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.sax.LinkContentHandler;
import org.apache.tika.sax.TeeContentHandler;
import org.apache.tika.sax.ToHTMLContentHandler;
import org.xml.sax.ContentHandler;

import java.io.*;

public class Metadatas {

    private Occurrences occurences;

    FileWriter fw;

    BufferedWriter bw;

    PrintWriter pw;

    private String extractionLink(InputStream input)throws Exception{
        try{

            LinkContentHandler linkHandler = new LinkContentHandler ();

            ContentHandler textHandler = new BodyContentHandler (-1) ;

            ToHTMLContentHandler toHTMLHandler = new
                    ToHTMLContentHandler ( );

            TeeContentHandler teeHandler = new TeeContentHandler (
                    linkHandler , textHandler , toHTMLHandler) ;

            Metadata metadata = new Metadata () ;

            ParseContext parseContext = new ParseContext () ;

            HtmlParser parser = new HtmlParser () ;

            parser . parse ( input , teeHandler , metadata , parseContext ) ;

            return linkHandler.getLinks().toString();
        }
        finally {

        }
    }

    public Metadatas() throws Exception{

        fw = new FileWriter("datosSalida/tablaMetadatos.csv");

        bw = new BufferedWriter(fw);

        pw = new PrintWriter(bw);
    }

    public void extractionMetadata(InputStream flujo, InputStream flujo2)throws Exception{

        try{

            Metadata metadata = new Metadata();

            //Le pasamos el -1 para que no nos salte un error de que el fichero sobrepasa el límite de caracteres.
            ContentHandler handler = new BodyContentHandler(-1);

            ParseContext parseContext = new ParseContext();

            AutoDetectParser parser = new AutoDetectParser();

            parser.parse(flujo, handler, metadata, parseContext);

            occurences = new Occurrences(handler);

            occurences.occurrencesToFile(metadata.get("title"));

            String links = extractionLink(flujo2);

            pw.println( "Título: "+metadata.get("title")+"\n"+
                        "Content Type: "+metadata.get(Metadata.CONTENT_TYPE)+"\n"+
                        "Content Encoding: "+metadata.get(Metadata.CONTENT_ENCODING)+"\n"+
                        "Lenguaje: "+metadata.get("language")+"\n"+
                        "Links: "+links+"\n"+
                        "__________________________________________________________________");
        }
        finally {

        }
    }

    public void finallyExtraction()throws Exception{

        pw.close();

        bw.close();

        fw.close();
    }

}
