

/**
 * class representing a treeNode
 */
class TreeNode{
    int val;
    Treenode left;
    Treenode right;
    TreeNode(int val){
        this.val = val;
        left = right = null;
    }
}

/**
 * class containing the driver code
 */
class FlattenTree{
    static Treenode prev;
    public static void main(String[] args){
        // create a new tree
        Treenode root = new Treenode(1);
        root.left = new Treenode(2);
        root.right = new Treenode(5);
        root.left.left = new Treenode(3);
        root.left.right = new Treenode(4);
        root.right.right = new Treenode(6);

        //flattens the tree
        flattenTree(root);
        // prints the flattened tree
        printFlattenedTree(root);
    }
    public static void flattenTree(Treenode root){
        if(root == null)
            return;
        //call recursively for right and then left side
        flattenTree(root.right);
        flattenTree(root.left);

        root.left = null;   // assign root's left as null
        root.right = prev;   // assign root's right as prev that tracks the previous visited node'
        prev = root;   //change previous node to keep track of it
    }

    //method to print the flattened tree
    public static void printFlattenedTree(Treenode root){
        while(root != null){
            System.out.println(root.val);
            root = root.right;
        }
    }

}