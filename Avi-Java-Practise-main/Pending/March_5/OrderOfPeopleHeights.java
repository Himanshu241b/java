package javaBasics.date_05_03_24;

import java.util.ArrayList;
import java.util.Collections;

public class OrderOfPeopleHeights {
    // Method to order the heights of people based on the number of people taller than them in front
    public static ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts) {
        ArrayList<Integer> order = new ArrayList<>(); // Resultant order of heights
        ArrayList<Node> nodes = new ArrayList<>(); // List to store height and infronts data as objects
        int n; // Number of people

        // Check for null input
        if (heights == null || infronts == null) {
            return order; // Return empty order
        }

        n = heights.size(); // Get the number of people

        Bit bit = new Bit(n); // Initialize Binary Indexed Tree (BIT) data structure

        // Update BIT with initial values
        for (int i = 1; i <= n; i++) {
            bit.update(i, 1);
        }

        // Create objects for each person with height and infronts data
        for (int i = 0; i < n; i++) {
            Node node = new Node(heights.get(i), infronts.get(i));
            nodes.add(node);
            order.add(0); // Initialize order list with zeros
        }

        // Sort nodes based on height in ascending order
        Collections.sort(nodes);

        // Arrange heights based on infronts data using BIT
        for (int i = 0; i < n; i++) {
            Node node = nodes.get(i);
            int index = getIth(bit, node.infronts + 1, n); // Get position to place the height
            order.set(index, node.height); // Set height at calculated position
        }

        return order; // Return ordered list of heights
    }

    // Method to get the position of the height based on infronts data
    public static int getIth(Bit bit, int index, int n) {
        int start = 1;
        int end = n;
        int count = end - start + 1;
        int res = 0; // Resultant position

        // Binary search to find the correct position
        while (count > 0) {
            int mid = (start + end) / 2;
            int val = bit.query(mid);

            if (val < index) {
                start = mid + 1;
            } else if (val > index) {
                end = mid - 1;
            } else if (val == index) {
                res = mid;
                end = mid - 1;
            }

            count /= 2;
        }

        bit.update(res, -1); // Update BIT after placing the height

        return res - 1; // Return zero-based position
    }

    // Node class to store height and infronts data
    static class Node implements Comparable<Node> {
        int height; // Height of the person
        int infronts; // Number of people taller than the person in front

        public Node(int h, int i) {
            height = h;
            infronts = i;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(height, node.height); // Compare nodes based on height
        }
    }

    // Bit class for Binary Indexed Tree operations
    static class Bit {
        int bit[]; // Binary Indexed Tree array
        int N; // Size of the array

        // Constructor to initialize the Bit with size N
        public Bit(int N) {
            this.bit = new int[N + 10]; // Initialize BIT array
            this.N = N; // Set the size of the array
        }

        // Method to update BIT with a new value at a given index
        public void update(int idx, int value) {
            while (idx > 0 && idx <= N) {
                bit[idx] += value; // Update BIT value at index
                idx += (idx & -idx); // Update index for next iteration
            }
        }

        // Method to query BIT for cumulative sum up to a given index
        public int query(int idx) {
            int res = 0; // Initialize result

            // Traverse BIT backwards to get cumulative sum
            while (idx > 0) {
                res += bit[idx]; // Add BIT value at index to result
                idx -= (idx & -idx); // Move to the parent node
            }

            return res; // Return cumulative sum
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Sample data
        ArrayList<Integer> heights = new ArrayList<>();
        ArrayList<Integer> infronts = new ArrayList<>();

        heights.add(5);
        heights.add(3);
        heights.add(2);
        heights.add(6);
        heights.add(1);
        heights.add(4);

        infronts.add(0);
        infronts.add(1);
        infronts.add(2);
        infronts.add(0);
        infronts.add(3);
        infronts.add(2);

        // Get ordered list of heights
        ArrayList<Integer> result = order(heights, infronts);

        // Print the result
        System.out.println(result);
    }
}
