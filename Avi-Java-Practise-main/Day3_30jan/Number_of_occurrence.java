package Day3_30jan;

import java.util.ArrayList;
import java.util.Scanner;

public class Number_of_occurrence {
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
        int count = 0;
        for(int i:arr)
        {
            if(i == x) count++;
        }

        System.out.println(count);
    }
}
