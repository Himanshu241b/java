import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MatrixElementsInEachRow {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 4, 5, 6}, {3, 4, 5, 6}, {5, 6, 7, 2}};
        int[][] matrix2 = {{4, 6}, {6, 4}, {2, 6}};

        List<Integer> result1 = findCommonElements(matrix1);
        List<Integer> result2 = findCommonElements(matrix2);

        System.out.println(result1); // Output: [5, 6]
        System.out.println(result2); // Output: [6]
    }

    public static List<Integer> findCommonElements(int[][] matrix) {
        int rows = matrix.length;
        Set<Integer> commonElements = new HashSet<>();

        // Add elements of the first row to the set
        for (int j = 0; j < matrix[0].length; j++) {
            commonElements.add(matrix[0][j]);
        }

        // Iterate through each subsequent row and find intersection with the set
        for (int i = 1; i < rows; i++) {
            Set<Integer> currentRowElements = new HashSet<>();
            for (int j = 0; j < matrix[i].length; j++) {
                currentRowElements.add(matrix[i][j]);
            }
            // Take intersection of the current row elements with the commonElements set
            commonElements.retainAll(currentRowElements);
        }

        // Convert set to list
        List<Integer> result = new ArrayList<>(commonElements);
        return result;
    }
}
