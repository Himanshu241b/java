import java.util.Scanner;
import java.util.Queue;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BinaryTreeBurningTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter node values separated by spaces:");
        String[] nodes = scanner.nextLine().trim().split(" ");
        TreeNode root = buildTree(nodes, 0);
        System.out.println("Enter node value to start burning from:");
        int startNode = scanner.nextInt();

        // Call the burnTime method to compute the time taken for burning
        int result = burnTime(root, startNode);
        System.out.println(result);

        scanner.close();
    }

    // Method to build a binary tree from an array representation
    public static TreeNode buildTree(String[] nodes, int index) {
        if (index >= nodes.length || nodes[index].equals("-1")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(nodes[index]));
        node.left = buildTree(nodes, 2 * index + 1);
        node.right = buildTree(nodes, 2 * index + 2);

        return node;
    }

    // Method to compute the time taken for burning
    public static int burnTime(TreeNode root, int startNode) {
        // Initialize a queue for BFS traversal
        Queue<TreeNode> queue = new LinkedList<>();
        // Map to keep track of the parent of each node
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();

        // Find the start node and add it to the queue
        TreeNode start = findStartNode(root, startNode, parentMap);
        queue.add(start);

        // Start time
        int time = 0;

        // Perform BFS traversal
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                // Add left child to the queue if it exists and has not been visited
                if (current.left != null && parentMap.get(current.left) != current) {
                    queue.add(current.left);
                }
                // Add right child to the queue if it exists and has not been visited
                if (current.right != null && parentMap.get(current.right) != current) {
                    queue.add(current.right);
                }
                // Add parent node to the queue if it exists and has not been visited
                if (parentMap.get(current) != null) {
                    queue.add(parentMap.get(current));
                }
            }
            time++; // Increment time after processing each level
        }

        return time - 1; // Subtract 1 to exclude the initial burning time of the start node
    }

    // Method to find the start node and populate the parent map
    public static TreeNode findStartNode(TreeNode root, int startNode, Map<TreeNode, TreeNode> parentMap) {
        if (root == null) {
            return null;
        }

        // If the start node is found, return it
        if (root.val == startNode) {
            return root;
        }

        // Search for the start node in the left subtree
        TreeNode left = findStartNode(root.left, startNode, parentMap);
        if (left != null) {
            parentMap.put(left, root);
            return left;
        }

        // Search for the start node in the right subtree
        TreeNode right = findStartNode(root.right, startNode, parentMap);
        if (right != null) {
            parentMap.put(right, root);
            return right;
        }

        return null; // Start node not found in the subtree
    }
}
