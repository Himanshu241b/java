public class T2Sum {
    public static void main(String[] args) {
        // Create a binary search tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        // Set the target value
        int target = 19;

        // Call the t2Sum method and print the result
        int result = t2Sum(root, target);
        System.out.println("Result: " + result);
    }

    public static int t2Sum(TreeNode A, int B) {
        Set<Integer> set = new HashSet<>();
        return t2SumHelper(A, B, set) ? 1 : 0;
    }

    private static boolean t2SumHelper(TreeNode root, int target, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        // Check if there exists a pair with sum equal to target
        if (set.contains(target - root.val)) {
            return true;
        }
        // Add the current node's value to the set
        set.add(root.val);
        // Recursively check left and right subtrees
        return t2SumHelper(root.left, target, set) || t2SumHelper(root.right, target, set);
    }
}
