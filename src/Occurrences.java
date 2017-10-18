import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.Ordering;
import com.google.common.collect.TreeMultimap;
import org.xml.sax.ContentHandler;

public class Occurrences {

    private Map<String, Integer> occurrences;
    private TreeMultimap<Integer, String> occurrencesSorted;

    private int totalOccurrences;

    public Occurrences(ContentHandler words){

        occurrences = new HashMap<String, Integer>();
        occurrencesSorted = TreeMultimap.create(Ordering.natural().reverse(),Ordering.natural());
        totalOccurrences= 0;

        String aux = "";
        boolean keep = false;
        boolean isLink = false;
        String text = words.toString().toLowerCase();

        for (int i = 0; i < text.length(); i++){


            //Parseamos el fichero correspondiente.

            if (isLink && text.charAt(i) != ' ' && text.charAt(i) != '"'){
                aux += text.charAt(i);
            }

            else if (text.charAt(i) != ' ' &&  text.charAt(i) != ',' && text.charAt(i) != '.'
                    && text.charAt(i) != '\n' && text.charAt(i) != '\t' && text.charAt(i) != '·'
                    && text.charAt(i) != '"' && text.charAt(i) != ':' && !isLink
                    && text.charAt(i) != '-' && text.charAt(i) != '“' && text.charAt(i) != ' '
                    && text.charAt(i) != ';' && text.charAt(i) != '(' && text.charAt(i) != ')'
                    && text.charAt(i) != '!' && text.charAt(i) != '¡' && text.charAt(i) != '?'
                    && text.charAt(i) != '¿' && text.charAt(i) != '”'){
                keep = true;
                aux += text.charAt(i);

                if (aux.equals("http"))
                    isLink = true;
            }
            else if (keep){

                if(occurrences.containsKey(aux)) {
                    occurrences.put(aux, occurrences.get(aux) + 1);
                }
                else{

                    occurrences.put(aux,1);
                    totalOccurrences++;

                }

                keep = false;
                isLink = false;

                aux = "";

            }
        }

        occurrences.forEach((k,v) -> occurrencesSorted.put(v,k));
    }

    public TreeMultimap<Integer,String> sortedOccurrences(){

        return occurrencesSorted;

    }

    public int getValue(){
        return totalOccurrences;
    }
}
