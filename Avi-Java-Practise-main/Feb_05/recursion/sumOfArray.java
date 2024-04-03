package Feb_05.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class sumOfArray {

    static int solve(ArrayList<Integer>arr, int n, int i, int sum)
    {
        //base case
        if(i >= n) return sum;

        sum += arr.get(i);
        return solve(arr, n, i+1, sum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> arr = new ArrayList<Integer>();

        System.out.println("Enter the array size value");
        int n = sc.nextInt();


        System.out.println("Enter the elements of array");
        for (int i = 1; i <= n; i++) {
            int el = sc.nextInt();
            arr.add(el);
        }
        int sum = 0;
        System.out.println(solve(arr, n, 0, sum));

    }
}
