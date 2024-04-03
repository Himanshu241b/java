package Feb_05.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuickSort {

    static int partition(ArrayList<Integer> arr, int l, int r)
    {
        int pivot = arr.get(r);

        int i = l-1;
        for(int j=l; j<r; j++)
        {
            if(arr.get(j) <= pivot)
            {
                i++;
                Collections.swap(arr, i, j);
            }
        }
        Collections.swap(arr,i+1, r);
        return i+1;
    }
    static void solve(ArrayList<Integer> arr, int l, int r)
    {
        //base case
        if(r <= l || r < 0 || l >= arr.size()) return;

        int pivot = partition(arr, l, r);

        solve(arr, l, pivot-1);
        solve(arr, pivot+1, r);
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

        solve(arr, 0, n-1);
        System.out.println(arr);
    }
}
