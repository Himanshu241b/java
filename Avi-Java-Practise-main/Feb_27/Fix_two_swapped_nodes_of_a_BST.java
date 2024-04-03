package Feb_27;
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}


public class Fix_two_swapped_nodes_of_a_BST {
    TreeNode first, middle, last, prev;

    public void recoverTree(TreeNode root) {
        // Initialize variables
        first = middle = last = prev = null;

        // Perform inorder traversal to find the swapped nodes
        inorder(root);

        // Swap the values of the two nodes
        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if (first != null && middle != null) {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        if (prev != null && root.val < prev.val) {
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }
        prev = root;

        inorder(root.right);
    }
    public static void main(String[] args) {
        // Construct the BST
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);

        // Print the original BST
        System.out.println("Original BST:");
        printInorder(root);
        System.out.println();

        // Fix the BST
        Fix_two_swapped_nodes_of_a_BST solution = new Fix_two_swapped_nodes_of_a_BST();
        solution.recoverTree(root);

        // Print the fixed BST
        System.out.println("Fixed BST:");
        printInorder(root);
    }

    // Helper method to print the inorder traversal of the BST
    private static void printInorder(TreeNode root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
}
