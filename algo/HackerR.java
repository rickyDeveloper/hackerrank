package algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vikasnaiyar on 21/09/18.
 */
public class HackerR {

    public static void main(String[] args) {
/*
        It
                has
        efficient
        high-level
        data
                structures
        and
                a
        simple
                but
        effective
                approach
        to
                objectoriented
        programming
                Python
        elegant
                syntax
        and
                dynamic
        typing*/

        String s = "Python is an easy to learn powerful programming language " +
                "It has efficient high-level data structures and a simple but effective approach to " +
                "objectoriented programming Python elegant syntax and dynamic typing" ;

        String t =         "Python is an easy to learn powerful programming language";

        // Write your code here
        List<String> words = new ArrayList<>();

        String[] sWords = t.split(" ");

        Trie root = new Trie('\0', false);

        for(String sWord: sWords) {
            addWordToTrie(root, sWord);
        }

        String[] tWords = s.split(" ");
        for(String tWord: tWords) {
            if(!isWordAvailableInTrie(root, tWord)) {
                System.out.println(tWord);
            }
        }


      /* return words; */
    }

    public static boolean isWordAvailableInTrie(Trie root, String word) {
        String tmp = word.trim();
        char[] characters = tmp.toCharArray();
        boolean isWordFound = true;

        for(char ch: characters) {
            if(root.childNodesMap.containsKey(ch)) {
                root = root.childNodesMap.get(ch);
            } else {
                isWordFound = false;
                break;
            }
        }

        if(isWordFound && root.isWord && root.count > 0) {
            root.count -= 1;
        } else {
            isWordFound = false;
        }

        return isWordFound;

    }

    public static void addWordToTrie(Trie root, String word) {
        String tmp = word.trim();
        char[] characters = tmp.toCharArray();
        for(char ch: characters) {
            if(root.childNodesMap.containsKey(ch)) {
                root = root.childNodesMap.get(ch);
            } else {
                Trie node = new Trie(ch, false);
                root.childNodesMap.put(ch, node);
                root = node;
            }
        }

        root.isWord = true;
        root.count += 1;
    }


    public static class Trie {
        char ch;
        boolean isWord;
        int count =0;
        Map<Character, Trie> childNodesMap;
        Trie(char ch, boolean isWord) {
            this.ch = ch;
            this.isWord = isWord;
            this.childNodesMap = new HashMap<>();
        }
    }
}
