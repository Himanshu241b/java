package Day6_02Feb;

import java.util.Scanner;

public class Search_A_2D_Matrix_2 {
    public static void main(String[] args) {
        //You are given a 2-D matrix of dimensions 'N' x 'M', each row of the matrix is sorted in non-decreasing order, and each column is sorted in non-decreasing order.
        //
        //You are also given an integer ‘X’. You are supposed to find whether 'X' is present in the given matrix.

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

        System.out.println("Enter the target value");
        int x = sc.nextInt();
        boolean found = false;
        int j=0;
        for(int i=0; i<m;  i++) if(mtx[i][n-1] < x) j++;
        System.out.println(j);

        int rw = 0, cl = n-1;
        while(rw < m && cl >= 0)
        {
            if(mtx[rw][cl] == x) {
                System.out.println("Yes");
                found  = true;
                break;
            }
            else if(mtx[rw][cl] > x) cl--;
            else rw++;
        }

        if(!found) System.out.println("no");
    }
}
