import java.util.*;

public class Mergeksortedarrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of arrays (k)
        System.out.print("Enter the number of sorted arrays (k): ");
        int k = scanner.nextInt();

        // Create an array to store the lengths of each array
        int[] lengths = new int[k];

        // Input the size of each array
        for (int i = 0; i < k; i++) {
            System.out.print("Enter the size of array " + (i + 1) + ": ");
            lengths[i] = scanner.nextInt();
        }

        // Create an array of arrays to store the arrays
        int[][] arrays = new int[k][];

        // Input the elements of each array
        for (int i = 0; i < k; i++) {
            arrays[i] = new int[lengths[i]];
            System.out.print("Enter elements of array " + (i + 1) + ": ");
            for (int j = 0; j < lengths[i]; j++) {
                arrays[i][j] = scanner.nextInt();
            }
        }

        
        int[] mergedArray = mergeKSortedArrays(arrays);

        
        System.out.println("Merged sorted array:");
        for (int num : mergedArray) {
            System.out.print(num + " ");
        }
    }

    public static int[] mergeKSortedArrays(int[][] arrays) {
        // Use PriorityQueue to merge the arrays
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
       //add elements of array to minheap
        for (int[] array : arrays) {
            for (int num : array) {
                minHeap.add(num);
            }
        }
        
        //make a array with size of minheap (total of all arrays lengths)
        int totalElements = minHeap.size();
        int[] mergedArray = new int[totalElements];
        
        //add to result array
        for (int i = 0; i < totalElements; i++) {
            mergedArray[i] = minHeap.poll();
        }
        
        return mergedArray;
    }
}
