import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Scanner;

//Node of Trie
class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    TrieNode(){
        children = new TrieNode[26];
        isEnd = false;
    }
}

//Trie class
class Trie{
    TrieNode root;

    //constructor
    Trie(){
        this.root = new TrieNode();
    }

    //method to insert string in trie
    public void insert(String str){
        TrieNode current = root;
        for(char strCharacter : str.toCharArray() ){
            int index = strCharacter - 'a';
            if(current.children[index] == null){
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEnd = true;
    }

    //wrapper method around countNodes
    public int countNodes(){
        return countNodes(root);
    }
    //method to count nodes in trie
    public int countNodes(TrieNode root){
        int count = 0;
        if(root == null){
            return count;
        }
        ++count; // count the current TrieNode
        for(int i = 0; i < 26; i++){
            if(root.children[i] != null){
                count += countNodes(root.children[i]);
            }
        }
        return count;
    }
}




public class CountDistinctSubstringsTrie {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string:");
        try {
            String inputString = scanner.next();
            Trie trie = new Trie();
            // insert every substring of inputString in trie
            for(int i = 0; i < inputString.length(); ++i){
                for(int j = i+1; j <= inputString.length(); ++j){
                    trie.insert(inputString.substring(i, j));
                }
            }
            System.out.println(trie.countNodes());
            // Rest of the code
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid string.");
        }
        scanner.close();
    }
}
