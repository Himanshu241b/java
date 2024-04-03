package javaBasics.date_05_03_24;

// Class to find the maximum sum of elements from two rows of a grid
class MaxSumNoAdjacent {

    // Method to find the maximum sum of elements from two rows of a grid
    public static int maxSum(int grid[][], int n) {

        // Initialize inclusive and exclusive sums
        int incl = Math.max(grid[0][0], grid[1][0]);
        int excl = 0, excl_new;
        int i;

        // Iterate through the grid elements
        for (i = 1; i < n; i++) {

            // Store the previous value of exclusive sum
            excl_new = Math.max(excl, incl);

            // Update inclusive sum for the current column
            incl = excl + Math.max(grid[0][i], grid[1][i]);

            // Update exclusive sum for the current column
            excl = excl_new;
        }

        // Return the maximum of inclusive and exclusive sums
        return Math.max(incl, excl);
    }

    // Main method to test the maxSum function
    public static void main(String[] args) {
        int grid[][] = {{ 1, 2, 3, 4},
                { 2, 3, 4, 5}};
        int n = 4;

        // Print the maximum sum
        System.out.println(maxSum(grid, n));
    }
}
