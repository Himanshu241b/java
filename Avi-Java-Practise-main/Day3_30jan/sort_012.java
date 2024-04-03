package Day3_30jan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class sort_012 {
    public static void main(String args[])
    {
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

        int low = 0, high = n-1, mid = 1;
        while(low<n && high>=0 && mid<n)
        {
            if(arr.get(mid) == 0 && low != mid){
                Collections.swap(arr, low, mid);
                low++;
            }
            else if(arr.get(mid) == 1){
                Collections.swap(arr, mid, high);
                high--;
            }
            else{
                mid++;
            }
        }
        for(int i:arr) System.out.print(i + " ");
    }
}
