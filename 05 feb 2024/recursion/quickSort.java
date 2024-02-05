import java.util.Scanner;
public class quickSort {
    
    public static void quickSort(int[] array) {
        if (array == null || array.length <= 1) {
            return; 
        }
        quickSort(array, 0, array.length - 1);
    }
    
    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }
    
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1; 
        
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        
        return i + 1;
    }
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
            
        System.out.println("Enter the size of array");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the ELEMENTS");
        for (int i = 0; i < n; i++) 
            array[i] = scanner.nextInt();
            
        quickSort(array);
        
        System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
  
}
