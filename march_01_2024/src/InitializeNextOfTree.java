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
        Treenode curr = newRoot;
        while(curr.left != null){
            newRoot = curr;
            while(newRoot.next != null){
                System.out.print(newRoot.val+"->");
                newRoot = newRoot.next;
            }
            System.out.println();
            curr = curr.left;
        }
    }

    public static Treenode initializeNext(Treenode root){

        for(Treenode head = root; head != null;){
            if(head.left == null)
                return root;

            Treenode prev = null;
            Treenode curr = head;

            while(curr != null){
                if(prev != null)
                    prev.right.next = curr.left;
                    curr.left = curr.right;

                    prev = curr;
                    curr = curr.next;
            }
            head = head.left;
        }
        return root;
    }
}