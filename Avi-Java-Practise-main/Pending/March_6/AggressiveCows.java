package javaBasics.date_06_03_24;

import java.util.Scanner;

public class AggressiveCows {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of K: ");
        int K = sc.nextInt(); // Read the value of K from user input
        int[] arr = {6, 7, 9, 11, 13, 15}; // Array representing positions of stalls
        int N = arr.length; // Length of array arr

        System.out.println(aggressive_cows(arr, N, K)); // Call the aggressive_cows method and print the result
    }

    // Method to check if it's possible to place 'c' cows with minimum distance 'x' between them
    public static boolean ok(int[] v, int x, int c)
    {
        int n = v.length; // Length of array v
        int count = 1; // Initialize count of cows placed with the first stall
        int d = v[0]; // Initialize distance 'd' with the first stall position
        for (int i = 1; i < n; i++) {
            if (v[i] - d >= x) { // If the distance between current stall and previous stall is greater than or equal to 'x'
                d = v[i]; // Update 'd' to current stall position
                count++; // Increment count of cows placed
            }
            else {
                continue; // Continue to next iteration if distance is less than 'x'
            }
        }
        if (count >= c) { // If number of cows placed is greater than or equal to required number of cows 'c'
            return true; // Return true indicating it's possible to place 'c' cows with minimum distance 'x'
        }
        return false; // Return false indicating it's not possible to place 'c' cows with minimum distance 'x'
    }

    // Method to find maximum minimum distance such that 'k' cows can be placed
    public static int aggressive_cows(int[] v, int n, int k)
    {
        long ans = -1; // Initialize answer with -1
        int maxi = 0; // Initialize maximum stall position with 0
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, v[i]); // Find maximum stall position
        }

        for (long i = 1; i <= maxi; i++) { // Iterate from 1 to maximum stall position
            if (ok(v, (int)i, k)) { // Check if it's possible to place 'k' cows with minimum distance 'i'
                ans = i; // Update answer with current minimum distance
            }
            else
                break; // Break the loop if it's not possible to place 'k' cows with minimum distance 'i'
        }
        return (int)ans; // Return the maximum minimum distance
    }
}
