// Question 13

import java.util.Scanner;
public class insertionsort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the size of array");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the ELEMENTS");
        for (int i = 0; i < n; i++) 
            arr[i] = scanner.nextInt();
        insertionSort(arr);
        System.out.println("Sorted array :");
        for(int i = 0; i < n; i++)
        System.out.print(" "+arr[i]);
            
        
    }
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i]; 
            int j = i - 1; // j is initially one less than i

           
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];    // shift the element forward and decrement j
                j = j - 1;
            }
            arr[j + 1] = key;   //AT LAST PUT KEY ELEMENT AT ITS CORRECT PLACE
        }
        
    }
}
