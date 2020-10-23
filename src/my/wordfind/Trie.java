/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.wordfind;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author JoeWallace
 */
public class Trie {
    /*
    This class implements a Trie to compress all the words in the dictionary.
    It allows fast searching and retrieval.
    */

    private static final int R = 26;

    private Node root;
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    private static class Node {
        private String val;
        private Node[] next = new Node[R];
    }

    public Trie() throws Exception {
        createTrie();
    }

    private void createTrie() throws Exception {
        String line;
        BufferedReader bufferreader = new BufferedReader(new FileReader("src/my/wordFind/words.txt"));
        line = bufferreader.readLine();
        while (line != null) {
            put(line);
            line = bufferreader.readLine();
        }
    }

    public void put(String key) {
        root = put(root, key, 0);
    }
    
    private Node put(Node x, String key, int d) {
        if (x == null) x = new Node();
        if (d == key.length() && x.val == null) {
            x.val = key;
            return x;
        }
        int c = alphabet.indexOf(key.charAt(d));
        if (x.next[c] == null) x.next[c] = new Node();
        put(x.next[c], key, d+1);
        return x;
    }

    public boolean isWord(String key) {
        //this method tests if the key is a full word
        Node x = getWord(root, key, 0);
        if (x == null) {
            return false;
        } else { 
            return (x.val != null && x.val.equals(key));
        }
    }
    
    private Node getWord(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        int c = alphabet.indexOf(key.charAt(d));
        return getWord(x.next[c], key, d+1);
    }  
    
    public boolean isPrefix(String prefix) {
        return getPrefix(root, prefix, 0) != null;
    }
    
    private Node getPrefix(Node x, String prefix, int d) {
        if (x == null) return null;
        if (d == prefix.length()) return x;
        int c = alphabet.indexOf(prefix.charAt(d));
        return getPrefix(x.next[c], prefix, d+1);
    }
}
