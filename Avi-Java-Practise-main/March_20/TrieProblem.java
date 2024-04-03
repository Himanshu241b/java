package March_20;

import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            curr.children.putIfAbsent(ch, new TrieNode());
            curr = curr.children.get(ch);
        }
        curr.isEndOfWord = true;
    }

    int countDistinctSubstrings() {
        return countDistinctSubstrings(root);
    }

    private int countDistinctSubstrings(TrieNode node) {
        if (node == null)
            return 0;

        int count = 0;
        if (node.isEndOfWord)
            count++;

        for (TrieNode child : node.children.values()) {
            count += countDistinctSubstrings(child);
        }
        return count;
    }
}

public class TrieProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            String s = scanner.next();
            System.out.println(countDistinctSubstrings(s));
        }

        scanner.close();
    }

    private static int countDistinctSubstrings(String s) {
        Trie trie = new Trie();
        for (int i = 0; i < s.length(); i++) {
            trie.insert(s.substring(i));
        }
        return trie.countDistinctSubstrings();
    }
}

