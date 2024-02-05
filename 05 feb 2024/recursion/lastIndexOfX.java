import java.util.Scanner;

public class lastIndexOfX {
    
    public static int lastIndex(int[] arr, int x, int currentIndex) {
        // Base case: If currentIndex is less than 0, return -1
        if (currentIndex < 0) {
            return -1;
        }
        
        // If the current element is equal to x, return the current index
        if (arr[currentIndex] == x) {
            return currentIndex;
        }
        
        // Recursively check the previous index
        return lastIndex(arr, x, currentIndex - 1);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int N = scanner.nextInt();
        
        int[] arr = new int[N];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        
        System.out.print("Enter the integer to find its last index: ");
        int x = scanner.nextInt();
        scanner.close();
        
        int lastIdx = lastIndex(arr, x, N - 1);
        System.out.println("Last index of " + x + " in the array: " + lastIdx);
    }
}
