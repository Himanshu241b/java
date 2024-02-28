/**
 * TreeNode class representing the nodes of tree
 */
class TreeNode{
    int val;    // value stored in node
    TreeNode left; // left node of tree element
    TreeNode right; // right node of tree element
    TreeNode(int val){
        this.val = val;
        left = right = null;
    }
}


class BinaryTreeSwap{
    static TreeNode first = null;
    static TreeNode second = null;
    static TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    public static void main(String[] args){
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(6);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(5);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(12);

        traverse(root);
        System.out.println(first.val +" "+second.val);
    }


    /**
     * Traverses the tree and updates the values of first second and prev nodes
     * @param root root node of binary tree
     */
    public static void traverse(TreeNode root) {
        if (root == null) return;

        // Traverse left subtree
        traverse(root.left);

        // Check the current node
        if (first == null && prev.val >= root.val) {
            first = prev;
        }
        if (first != null && prev.val >= root.val) {
            second = root;
        }
        prev = root;

        // Traverse right subtree
        traverse(root.right);
    }
}