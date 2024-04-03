package javaBasics.date_06_03_24;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Tree node class
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BurnBinaryTree {
    // Function to search for a target node and print the sequence of burning nodes
    public static int search(TreeNode root, int num, Map<Integer, Set<Integer>> levelOrderMap) {
        if (root != null) {
            // Check if the target node is found
            if (root.val == num) {
                // Store the level order for the left and right subtrees
                levelOrderStoredInMap(root.left, 1, levelOrderMap);
                levelOrderStoredInMap(root.right, 1, levelOrderMap);
                // Return to prevent further function calls
                return 1;
            }
            int k = search(root.left, num, levelOrderMap);
            if (k > 0) {
                // Store the root in the map with level k
                storeRootAtK(root, k, levelOrderMap);
                // Store the level order for the other branch
                levelOrderStoredInMap(root.right, k + 1, levelOrderMap);
                return k + 1;
            }
            k = search(root.right, num, levelOrderMap);
            if (k > 0) {
                // Store the root in the map with level k
                storeRootAtK(root, k, levelOrderMap);
                // Store the level order for the other branch
                levelOrderStoredInMap(root.left, k + 1, levelOrderMap);
                return k + 1;
            }
        }
        return -1; // Base condition
    }

    // Function to store the level order of nodes in the tree
    public static void levelOrderStoredInMap(TreeNode root, int k, Map<Integer, Set<Integer>> levelOrderMap) {
        if (root != null) {
            storeRootAtK(root, k, levelOrderMap);
            levelOrderStoredInMap(root.left, k + 1, levelOrderMap);
            levelOrderStoredInMap(root.right, k + 1, levelOrderMap);
        }
    }

    // Function to store the root node at level k in the map
    private static void storeRootAtK(TreeNode root, int k, Map<Integer, Set<Integer>> levelOrderMap) {
        if (levelOrderMap.containsKey(k)) {
            levelOrderMap.get(k).add(root.val);
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(root.val);
            levelOrderMap.put(k, set);
        }
    }

    // Driver Code
    public static void main(String[] args) {
        // Create a binary tree
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(13);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(15);
        TreeNode left = root.right.left;
        TreeNode right = root.right.right;
        left.left = new TreeNode(21);
        left.right = new TreeNode(24);
        right.left = new TreeNode(22);
        right.right = new TreeNode(23);

        // Create a map to store the level order of nodes
        Map<Integer, Set<Integer>> levelOrderMap = new HashMap<>();

        // Search for the target node (14) and store its level order in the map
        search(root, 14, levelOrderMap);

        // Print the target node and its burning sequence
        System.out.println(14);
        for (Integer level : levelOrderMap.keySet()) {
            for (Integer val : levelOrderMap.get(level)) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
