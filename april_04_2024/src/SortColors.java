import java.util.Arrays;
import java.util.Scanner;

public class SortColors {
    public static void sortColors(int[] A) {
        int n = A.length;
        int low = 0, mid = 0, high = n - 1;

        while (mid <= high) {
            if (A[mid] == 0) {
                swap(A, low, mid);
                low++;
                mid++;
            } else if (A[mid] == 1) {
                mid++;
            } else {
                swap(A, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] A = new int[n];

        // Input array elements
        System.out.println("Enter the elements of the array (0, 1, or 2):");
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        // Sort the array
        sortColors(A);
        System.out.println("Sorted array: " + Arrays.toString(A));

        scanner.close();
    }
}

