import java.util.Arrays;
import java.util.Scanner;

public class MedianOfSortedMatrix {

    public static int findMedian(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        // Flatten the matrix into a 1D array
        int[] flattened = new int[rowCount * colCount];
        int index = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                flattened[index++] = matrix[i][j];
            }
        }

        // Sort the flattened array
        Arrays.sort(flattened);

        // Find the median
        int medianIndex = flattened.length / 2;
        return flattened[medianIndex];
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter rows in matrix:");
        int rows = scanner.nextInt();
        System.out.println("Enter columns in matrix:");
        int columns = scanner.nextInt();
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }

            System.out.println(findMedian(matrix));

        scanner.close();
    }
}
