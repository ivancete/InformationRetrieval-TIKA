import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.Ordering;
import com.google.common.collect.TreeMultimap;
import org.xml.sax.ContentHandler;

public class occurrences {

    private Map<String, Integer> occurrences;
    private TreeMultimap<Integer, String> occurrencesSorted;

    private int totalOccurrences;

    public occurrences ( ContentHandler words){

        occurrences = new HashMap<String, Integer>();
        occurrencesSorted = TreeMultimap.create(Ordering.natural().reverse(),Ordering.natural());
        totalOccurrences= 0;

        String aux = "";
        boolean keep = false;
        boolean isLink = false;

        for (int i = 0; i < words.toString().length(); i++){


            //Parseamos el fichero correspondiente.

            if (isLink && words.toString().charAt(i) != ' ' && words.toString().charAt(i) != '"'){
                aux += words.toString().charAt(i);
            }

            else if (words.toString().charAt(i) != ' ' &&  words.toString().charAt(i) != ',' && words.toString().charAt(i) != '.'
                    && words.toString().charAt(i) != '\n' && words.toString().charAt(i) != '\t' && words.toString().charAt(i) != '·'
                    && words.toString().charAt(i) != '"' && words.toString().charAt(i) != ':' && !isLink
                    && words.toString().charAt(i) != '-'){
                keep = false;
                aux += words.toString().charAt(i);

                if (aux.equals("http"))
                    isLink = true;
            }
            else if (!keep){

                if(occurrences.containsKey(aux)) {
                    occurrences.put(aux, occurrences.get(aux) + 1);
                }
                else{

                    occurrences.put(aux,1);
                    totalOccurrences++;

                }

                keep = true;
                isLink = false;

                aux = "";
            }
        }

        occurrences.forEach((k,v) -> occurrencesSorted.put(v,k));
    }


    public Map<String, Integer> shortOccurrences(){

        return occurrences;
    }

    public TreeMultimap<Integer,String> shortedOccurrences(){

        return occurrencesSorted;

    }

    public int getValue(){
        return totalOccurrences;
    }
}
