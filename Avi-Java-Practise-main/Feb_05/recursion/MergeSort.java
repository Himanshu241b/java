package Feb_05.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class MergeSort {

    static void merge(ArrayList<Integer> arr, int l, int m, int r)
    {
        int n1 = m-l+1;
        int n2 = r-m;
        int[] L = new int[n1];
        int[] R = new int[n2];

        //copy data from arr to L, R for sorting
        for(int i=0; i<n1; i++) L[i] = arr.get(l+i);
        for(int i=0; i<n2; i++) R[i] = arr.get(m+1+i);

        int k=l;
        int i=0,j=0;
        while(i < n1 && j < n2)
        {
            if(L[i] < R[j]) arr.set(k, L[i++]);
            else arr.set(k, R[j++]);
            k++;
        }
        while(i < n1) arr.set(k++, L[i++]);
        while(j < n2) arr.set(k++, R[j++]);

    }

    static void solve(ArrayList<Integer> arr, int l, int r)
    {
        //base case
        if(l-r == 0 || (l >= arr.size() && r < 0)) return;

        //get mid point
        int mid = l + (r-l)/2;

        solve(arr, l, mid);
        solve(arr, mid+1, r);

        merge(arr, l, mid, r);
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
