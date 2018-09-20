package algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by vikasnaiyar on 20/09/18.
 */
public class SearchWordsOfString {

    public static void main(String[] args) {

        String strA = "This is jungle book jungle";
        String strB = "I saw jungle book movie today";

        String[] strAWords = strA.split(" ");

        Trie root = new Trie('\0', false);

        for (String word: strAWords
             ) {
            String trimmedWord = word.trim();

            if(!trimmedWord.isEmpty()) {
                addWordToTrie(trimmedWord, root);
            }
        }

        String[] strBWords = strB.split(" ");

        for (String word: strBWords
                ) {
            String trimmedWord = word.trim();

            if(!trimmedWord.isEmpty()) {
                System.out.println( trimmedWord + " = " + searchWordInTrie(trimmedWord, root));
            }
        }


    }

    private static int searchWordInTrie(String word, Trie root) {

        int wordCount = 0;

        char[] chars = word.toCharArray();
        if (chars.length > 0) {

            for (char ch: chars
                    ) {
                if(root.nextCharsMap.containsKey(ch)) {
                    root = root.nextCharsMap.get(ch);
                } else {
                    root = null;
                    break;
                }
            }

            if(root != null && root.isWord) {
                wordCount = root.wordCount;
            }
        }


        return wordCount;
    }


    private static  void addWordToTrie(String word, Trie root) {

        char[] chars = word.toCharArray();
        if(chars.length > 0) {
            for (char ch: chars
                    ) {
                if(root.nextCharsMap.containsKey(ch)) {
                    root = root.nextCharsMap.get(ch);
                } else {
                    Trie newNode = new Trie(ch, false);
                    root.nextCharsMap.put(ch, newNode);
                    root = newNode;
                }
            }

            root.isWord = true;
            root.wordCount += 1;
        }
    }

    static class Trie {

        char ch;
        boolean isWord;
        int wordCount;
        Map<Character, Trie> nextCharsMap;

        Trie(char ch, boolean isWord) {
            this.ch = ch;
            this.isWord = isWord;
            this.nextCharsMap = new HashMap<>();
            this.wordCount = 0;
        }

    }

}
