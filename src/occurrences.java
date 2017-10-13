import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.tika.Tika;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.apache.tika.language.LanguageIdentifier;
import org.apache.tika.language.detect.LanguageDetector;
import org.apache.tika.langdetect.OptimaizeLangDetector;
import org.apache.tika.language.detect.LanguageResult;

public class occurrences {

    private HashMap<String, Integer> occurrences;

    public occurrences ( ContentHandler words){

        occurrences = new HashMap<String, Integer>();

        String [] occurrencias = words.toString().split(" ");

        for (String cadena : occurrencias){

            if (occurrences.containsKey(cadena)){
                occurrences.put(cadena, occurrences.get(cadena)+1);
            }

            else{
                occurrences.put(cadena, 1);
            }
        }
    }


    public HashMap<String, Integer> shortOccurrences(){
        return occurrences;
    }
}
