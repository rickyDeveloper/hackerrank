package algo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vikasnaiyar on 07/09/18.
 */
public class DictionaryWords {

    public static void main(String[] args) {

        String[] magazine =  {"two", "times" ,"three", "is", "not", "four"};

        String[] note = { "two", "times" , "two", "is", "four"};


        Set<String> dictionaryWords = new HashSet<>();
        int wordsCount = magazine.length;
        for(int i=0; i<wordsCount; i++) {
            dictionaryWords.add(magazine[i]);
        }


        boolean containsAllWOrds = true;
        for(String word: note) {
            if(!dictionaryWords.contains(word)) {
                containsAllWOrds = false;
                break;
            } else {
                dictionaryWords.remove(word);
            }
        }

        if(containsAllWOrds) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}
