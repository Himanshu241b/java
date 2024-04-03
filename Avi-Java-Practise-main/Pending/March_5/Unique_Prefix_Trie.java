package javaBasics.date_05_03_24;

public class Unique_Prefix_Trie {

    // Constants for maximum number of characters and maximum word length
    static final int MAX = 256;
    static final int MAX_WORD_LEN = 500;

    // TrieNode class representing each node in the Trie
    static class TrieNode {
        TrieNode[] child = new TrieNode[MAX];
        int freq; // To store frequency

        // Constructor to initialize TrieNode
        TrieNode() {
            freq = 1;
            for (int i = 0; i < MAX; i++)
                child[i] = null;
        }
    }

    // Root of the Trie
    static TrieNode root;

    // Function to insert a word into the Trie
    static void insert(String str) {
        int len = str.length();
        TrieNode pCrawl = root;

        for (int level = 0; level < len; level++) {
            int index = str.charAt(level);
            if (pCrawl.child[index] == null)
                pCrawl.child[index] = new TrieNode();
            else
                (pCrawl.child[index].freq)++;
            pCrawl = pCrawl.child[index];
        }
    }

    // Utility function to find and print all unique prefixes
    static void findPrefixesUtil(TrieNode root, char[] prefix, int ind) {
        if (root == null)
            return;

        if (root.freq == 1) {
            prefix[ind] = '\0';
            int i = 0;
            while (prefix[i] != '\0')
                System.out.print(prefix[i++]);
            System.out.print(" ");
            return;
        }

        for (int i = 0; i < MAX; i++) {
            if (root.child[i] != null) {
                prefix[ind] = (char) i;
                findPrefixesUtil(root.child[i], prefix, ind + 1);
            }
        }
    }

    // Function to find and print all unique prefixes in the given array of strings
    static void findPrefixes(String arr[], int n) {
        root = new TrieNode();
        root.freq = 0;
        for (int i = 0; i < n; i++) {
            insert(arr[i]);
        }

        char[] prefix = new char[MAX_WORD_LEN];
        findPrefixesUtil(root, prefix, 0);
    }

    // Main method to test the functionality
    public static void main(String args[]) {
        String arr[] = {"zebra", "dog", "duck", "dove"};
        int n = arr.length;
        findPrefixes(arr, n);
    }
}
