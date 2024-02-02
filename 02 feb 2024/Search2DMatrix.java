import java.util.*;
public class Search2DMatrix {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        PriorityQueue<Integer> queue =new PriorityQueue<Integer>();
        System.out.println("Enter rows in matrix: ");
        int rows = sc.nextInt();
        System.out.println("Enter columns in matrix: ");
        int columns = sc.nextInt();
        System.out.println("Enter target to search");
        int target = sc.nextInt();
        int[][] matrix = new int[rows][columns];
        System.out.println("Enter array elements");
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < columns; j++)
                matrix[i][j] = sc.nextInt(); 
        System.out.println(searchMatrix(matrix, target));
    }
    static String searchMatrix(int[][] matrix, int X) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols - 1; // Start from the top-right corner

        while (row < rows && col >= 0) {
            if (matrix[row][col] == X) {
                return "Yes"; // Found X
            } else if (matrix[row][col] > X) {
                col--; // Move left in the matrix
            } else {
                row++; // Move down in the matrix
            }
        }
        return "No"; // X not found
    }

}
