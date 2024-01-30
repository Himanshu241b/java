//question 3

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class duplicateoccurance {
    public static void main(String[] args) {
        Set<Integer> set  = new HashSet<Integer>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the size of array");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the ELEMENTS");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for(int i = 0; i < n; i++) {
            if(!set.add(arr[i]))  //if it returns  false then it is repeated
                System.out.println(" " +arr[i]);
    }
}
}
