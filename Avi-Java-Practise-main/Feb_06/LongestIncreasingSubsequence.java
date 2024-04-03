package Feb_06;

import java.util.ArrayList;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
    //For a given array with N elements, you need to find the length of the longest subsequence
    //from the array such that all the elements of the subsequence are sorted in strictly increasing order.

    static int solve(ArrayList<Integer> arr, int n, int i, int prev)
    {
        //base case
        if(i == n) return 0;

        //processing
        //exclusion
        int len = 0+ solve(arr, n, i+1, prev);

        //inclusion
        if(prev == -1 || arr.get(i) > arr.get(prev)) {
            len = Math.max(len, 1+solve(arr, n, i+1, i));
        }



        return len;

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //CREATED AND TOOK INPUT IN ARRAYLIST
        ArrayList<Integer> arr = new ArrayList<Integer>();

        System.out.println("Enter the array size value");
        int n = sc.nextInt();


        System.out.println("Enter the elements of array");
        for (int i = 1; i <= n; i++) {
            int el = sc.nextInt();
            arr.add(el);
        }

        int len = solve(arr, n, 0, -1);
        System.out.println(len);
    }
}
