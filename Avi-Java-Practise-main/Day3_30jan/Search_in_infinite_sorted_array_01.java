package Day3_30jan;

import java.util.ArrayList;
import java.util.Scanner;

public class Search_in_infinite_sorted_array_01 {

    public static void main(String []args) {
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

        int s = 0, e = 1, mid = s+(e-s)/2;
        int res = -1;
        boolean found = false;
        while(!found && e < n){
            while(s < e)
            {
                if(arr.get(mid) == 1){
                    res = mid;
                    e = mid-1;
                    found = true;
                }
                else if(arr.get(mid) == 0) s = mid+1;

                mid = s+(e-s)/2;
            }
            e *= 2;
        }
        System.out.println(res);
    }
}
