/**
 * class to represent a treeNode
 */
class Treenode {
    int val;
    Treenode left;
    Treenode right;
    Treenode next;
    Treenode(int val){
        this.val = val;
        left = right = next = null;
    }
}

/**
 * Main class containing the driver code
 */
class InitializeNextOfTree{
    public static void main(String[] args){
        Treenode root = new Treenode(1);
        root.left = new Treenode(3);
        root.right = new Treenode(2);
        root.left.left = new Treenode(4);
        root.right.right = new Treenode(6);
        root.right.left = new Treenode(8);
        root.left.right = new Treenode(9);

        Treenode newRoot = initializeNext(root);

        //print the tree level by level
        while(newRoot != null) {
            Treenode curr = newRoot;
            while (curr != null) {
                System.out.print(curr.val + " ");
                curr = curr.next;
            }
            System.out.println();
            newRoot = newRoot.left;
        }
    }

    public static Treenode initializeNext(Treenode root){

        for(Treenode head = root; head != null;){
            if(head.left == null)   // if left is null then it means no children nodes to connect now
                return root;

            Treenode prev = null;
            Treenode curr = head;    //curr always pointing starting node of every level in starting

            while(curr != null){
                if(prev != null)    //  for first node of every level, prev pointing to null
                    prev.right.next = curr.left;     //connect prev node right to curr left node
                curr.left.next = curr.right;    // connect same children nodes of parent

                prev = curr;     // move prev and curr node to next node
                curr = curr.next;

            }
            head = head.left;    // move head to next level
        }
        return root;
    }
}