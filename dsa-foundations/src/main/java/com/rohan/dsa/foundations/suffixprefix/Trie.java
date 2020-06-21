package com.rohan.dsa.foundations.suffixprefix;

import java.util.HashMap;
import java.util.Map;

/**
 * A Trie is a data structure for storing strings
 * <p>
 * A Trie is a tree and each node in it contains the numbers of pointer equal
 * to the number of characters of the alphabets.
 * <p>
 * The tries can insert and find string in O(L) time (where L represents the length of a single word)
 * <p>
 * Insert/delete/search into trie data structure
 * <p>
 * Reference
 * https://en.wikipedia.org/wiki/Trie
 */
public class Trie {

    private class TrieNode {

        // Map take care of UTF chars also
        private Map<Character, TrieNode> children;
        private boolean endOfWord;

        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Insert word in a trie.
     */
    public void insertIterative(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }

        // Mark the end of word
        current.endOfWord = true;
    }

    public void insertRecursive(String word) {
        insertRecursive(root, word, 0);
    }

    private void insertRecursive(TrieNode current, String word, int index) {

        // Base case
        if (index == word.length()) {
            // End of the word is reached; Mark end of word
            current.endOfWord = true;
            return;
        }

        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);

        // If it does not exist in the current children
        if (node == null) {
            node = new TrieNode();
            current.children.put(ch, node);
        }

        insertRecursive(node, word, index + 1);
    }

    /**
     * Search word in a trie.
     */
    public boolean searchIterative(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.endOfWord;
    }

    public boolean searchRecursive(String word) {
        return searchRecursive(root, word, 0);
    }

    private boolean searchRecursive(TrieNode current, String word, int index) {
        if (index == word.length()) {
            return current.endOfWord;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            return false;
        }

        return searchRecursive(node, word, index + 1);
    }

    /**
     * Delete word from trie.
     */
    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            // If no such word exists
            if (!current.endOfWord) {
                return false;
            }

            // Eg. "abc" and "abcd" => Delete "abc"
            current.endOfWord = false;
            return current.children.size() == 0;
        }

        // check if exist in table
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            return false;
        }

        boolean shouldDeleteFirstNode = delete(node, word, index + 1);
        if (shouldDeleteFirstNode) {
            current.children.remove(ch);

            // If no mapping are left in the current node.
            return current.children.size() == 0;
        }

        return false;
    }


    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insertIterative("abcd");
        trie.insertRecursive("abc");

        System.out.println(trie.searchIterative("abc"));
        System.out.println(trie.searchRecursive("abcd"));

        trie.delete("abc");
        System.out.println("After deleting abc. Does it exists? " + trie.searchRecursive("abc"));

        trie.delete("abcd");
        System.out.println("After deleting abcd. Does it exists? " + trie.searchRecursive("abcd"));
    }

}
