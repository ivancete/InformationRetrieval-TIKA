import java.util.Map;
import java.util.TreeMap;
import org.xml.sax.ContentHandler;

public class occurrences {

    private Map<String, Integer> occurrences;

    private int totalOccurrences;

    public occurrences ( ContentHandler words){

        occurrences = new TreeMap<String, Integer>();
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
    }


    public Map<String, Integer> shortOccurrences(){

        return occurrences;
    }

    public int getValue(){
        return totalOccurrences;
    }
}
