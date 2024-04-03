package javaBasics.date_01_03_24;

class Node {
    int val; // Value stored in the node
    Node left; // Reference to the left child node
    Node right; // Reference to the right child node

    static Node prev; // Static variable used for flattening the binary tree

    // Default constructor
    public Node() {
    }

    // Constructor to create a node with a specific value
    public Node(int val) {
        this.val = val;
    }

    // Constructor to create a node with a specific value and children
    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    // Method to print the binary tree in inorder traversal
    public static void printInorder(Node root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    // Method to flatten the binary tree
    public static void flatten(Node root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

}

// Main class to demonstrate flattening of a binary tree
public class FlattenBinaryTree {
    public static void main(String[] args) {
        // Create a binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);

        // Print the binary tree before flattening
        Node.printInorder(root);

        // Flatten the binary tree
        Node.flatten(root);

        // Print the flattened binary tree
        System.out.println();
        Node.printInorder(root);
    }
}
