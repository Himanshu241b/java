package Day6_02Feb;

import java.util.Scanner;

public class UpdatedThirdQuest {
    public static void main(String[] args) {
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



        for(int i=0; i<m; i++)
        {
            int col = i;
            for(int j=0; j<n-i && col < n; j++)
            {
                System.out.print(mtx[j][col++] + " ");
            }
            System.out.println();
        }
    }
}
