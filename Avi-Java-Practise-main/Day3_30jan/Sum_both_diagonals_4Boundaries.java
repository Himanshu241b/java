package Day3_30jan;

import java.util.ArrayList;
import java.util.Scanner;

public class Sum_both_diagonals_4Boundaries {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        //CREATED AND TOOK INPUT IN ARRAYLIST
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int sum = 0;

        //for sides
//        for 1st row
        for(int j=0; j<arr[0].length; j++) sum += arr[0][j];

        //for last row
        for(int j=0; j<arr[0].length; j++) sum += arr[arr.length-1][j];

        //for first col
        for(int i=1; i<arr.length-1; i++) sum += arr[i][0];

        //for last col
        for(int i=1; i<arr.length-1; i++) sum += arr[i][arr.length-1];

//      for diagonal 1
        for(int i=1; i<arr.length-1; i++) sum += arr[i][i];

//      for diagonal 2
        int j = arr.length-2;
        for(int i=1; i<arr.length-1; i++) if(i != j) sum += arr[i][j--];

        System.out.println(sum);




    }
}
