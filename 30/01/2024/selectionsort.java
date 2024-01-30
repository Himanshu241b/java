//question 14
import java.util.Scanner;
public class selectionsort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the size of array");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the ELEMENTS");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
    }
    int res[] = SelectionSort(arr);
    for(int i = 0; i < res.length; i++) 
        System.out.print(res[i]+" ");

}
    public static int[] SelectionSort(int[] arr) {
        int n = arr.length;

        // One by one move the boundary of the unsorted subarray
        for (int i = 0; i < n-1; i++) {
            // Find the minimum element in the unsorted array
            int minIndex = i;
            for (int j = i+1; j < n; j++) 
                if (arr[j] < arr[minIndex]) 
                    minIndex = j;
        
            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}


