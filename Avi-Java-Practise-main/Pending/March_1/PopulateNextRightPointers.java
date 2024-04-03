package javaBasics.date_01_03_24;

// TreeNode class represents nodes in a binary tree
class TreeNode {
    int val; // Value of the node
    TreeNode left; // Reference to the left child
    TreeNode right; // Reference to the right child
    TreeNode next; // Reference to the next node in the same level (used in this context)

    // Constructor to initialize a TreeNode with a value
    public TreeNode(int val) {
        this.val = val;
    }

    // Constructor to initialize a TreeNode with a value and its children
    public TreeNode(int val, TreeNode left, TreeNode right, TreeNode next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    // Utility method to print the tree in inorder traversal
    public static void printInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
}

public class PopulateNextRightPointers {

    // Method to connect nodes at the same level to their right nodes
    public static TreeNode connectRight(TreeNode root) {
        TreeNode head = root; // Initialize the head of the current level
        for (head = root; head != null;) { // Iterate through each level
            if (head.left == null) { // If the left child of the current node is null, we're at the last level
                return root; // Return the root of the tree
            }
            TreeNode prev = null; // Initialize a pointer to the previous node
            TreeNode curr = head; // Initialize a pointer to the current node

            while (curr != null) { // Iterate through the current level
                if (prev != null) { // If the previous node is not null, connect the right child of the previous node to the left child of the current node
                    prev.right.next = curr.left;
                    curr.left.next = curr.right; // Connect the left child of the current node to the right child of the current node
                }
                prev = curr; // Update the previous node to the current node
                curr = curr.next; // Move to the next node in the same level
            }
            head = head.left; // Move to the left child of the current level's head for the next level
        }
        return root; // Return the root of the modified tree
    }

    // Main method
    public static void main(String[] args) {
        // Create a binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Connect right pointers for nodes in the tree
        connectRight(root);
        // Print the tree in inorder traversal
        TreeNode.printInorder(root);
    }
}
