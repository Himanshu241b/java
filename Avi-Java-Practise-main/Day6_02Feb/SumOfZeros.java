package Day6_02Feb;

import java.util.Scanner;

public class SumOfZeros {

    public static int countOnes(int[][] mtx, int i, int j)
    {
        int r = mtx.length;
        int c = mtx[0].length;

        int count = 0;

        //for row on left
        if(j > 0 && mtx[i][j-1] == 1) count++;

        //for row right
        if(j < c-1 && mtx[i][j+1] == 1) count++;

        //for col up
        if(i > 0 && mtx[i-1][j] == 1) count++;

//        for col down
        if(i < r-1 && mtx[i+1][j] == 1) count++;

        return count;
    }
    public static void main(String[] args) {
        //You are given a binary matrix (it contains only 0s and 1s) with dimensions ‘N * M’. You need to find and return the sum of coverages of all zeros of the given matrix.
        //
        //Coverage for a particular 0 is defined as the total number of ‘1s’ around it (i.e., immediate left, immediate right, immediate up, and immediate bottom positions).

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the row size of matrix");
        int m = sc.nextInt();
        System.out.println("Enter the col size of matrix");
        int n = sc.nextInt();

        int[][] mtx = new int[m][n];

        System.out.println("please enter the data for matrix as m[row][col]");
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                mtx[i][j]  = sc.nextInt();
            }
        }

        int count = 0;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(mtx[i][j] == 0){
                        count += countOnes(mtx, i, j);
                }
            }
        }

        System.out.println(count);
    }
}
