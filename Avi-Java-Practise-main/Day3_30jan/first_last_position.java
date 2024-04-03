package Day3_30jan;

import java.util.ArrayList;
import java.util.Scanner;

public class first_last_position {
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);

        //CREATED AND TOOK INPUT IN ARRAYLIST
        ArrayList<Integer> arr = new ArrayList<Integer>();

        System.out.println("Enter the array size value");
        int n = sc.nextInt();


        System.out.println("Enter the elements of array");
        for(int i=1; i<=n; i++)
        {
            int el = sc.nextInt();
            arr.add(el);
        }

        System.out.println("Enter the x value");
        int x = sc.nextInt();

        int s = 0, e = n-1, mid = s + (e-s)/2;
        int frst = 0, lst = 0;

        //first occr
        while(s <= e)
        {
            if(arr.get(mid) == x){
                frst = mid;
                e = mid-1;
            }
            else if(arr.get(mid) < x) s = mid + 1;
            else e = mid-1;
            mid = s+(e-s)/2;
        }

        //last pccr
        s = 0; e = n-1; mid = s+(e-s)/2;
        while(s <= e){
            if(arr.get(mid) == x){
                lst = mid;
                s = mid+1;
            }
            else if(arr.get(mid) < x) s = mid + 1;
            else e = mid-1;
            mid = s+(e-s)/2;
        }
        System.out.println("First: "+ frst + "\nLast: "+ lst);
    }
}
