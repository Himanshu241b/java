package Feb_05;

import java.util.ArrayList;
import java.util.Scanner;

public class Total_score {
    public static void main(String[] args) {

//        1.Given an array of integers, keep a total score based on the following:
//        1. Add 1 point for every even number in the array
//        2. Add 3 points for every odd number in the array, except for the number 5
//        3. Add 5 points for every time you encounter a 5 in the array
//        If an empty or null array is passed to the function, return 0.

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

        int score = 0;

        for(int i: arr)
        {
            if(i%2 == 0) score += 1;
            else if(i == 5) score += 5;
            else score += 3;
        }
        System.out.println(score);
    }
}
