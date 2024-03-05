//imports
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Class representing a node of trie
 */
class TrieNode {
    Map<Character, TrieNode> children;
    int count;

    public TrieNode() {
        children = new HashMap<>();
        count = 0;
    }
}

/**
 * Class representing trie data structure
 */
class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * method to insert in trie
     * @param word the word to insert
     */
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
            node.count++;
        }
    }

    /**
     * method to find prefix of a word
     * @param word the word to find prefix of
     * @return the found prefix
     */
    public String findPrefix(String word) {
        TrieNode node = root;
        StringBuilder prefix = new StringBuilder();
        for (char c : word.toCharArray()) {
            prefix.append(c);
            node = node.children.get(c);
            if (node.count == 1) {
                break;
            }
        }
        return prefix.toString();
    }
}

/**
 * Main class containing the driver code
 */
public class ShortestUniquePrefix {

    /**
     * method to add words to trie and find prefixes of each word
     * @param words array of words
     * @return prefix array
     */
    public static List<String> shortestUniquePrefix(String[] words) {
        Trie trie = new Trie();
        List<String> prefixes = new ArrayList<>();

        for (String word : words) {
            trie.insert(word);
        }

        for (String word : words) {
            String prefix = trie.findPrefix(word);
            prefixes.add(prefix);
        }
        return prefixes;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of string array");
        int size = scanner.nextInt();
        String[] words = new String[size];
        System.out.println("Enter the "+size+" words");
        for(int word=0; word < size; ++word)
            words[word] = scanner.next();
        List<String> prefixes = shortestUniquePrefix(words);
        System.out.println(prefixes);
    }
}