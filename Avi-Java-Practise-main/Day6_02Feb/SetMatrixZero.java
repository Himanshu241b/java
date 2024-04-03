package Day6_02Feb;
import java.util.*;

public class SetMatrixZero {

    public static void setZero(int[][] m, int i, int j)
    {
        int r = m.length;
        int c = m[0].length;

        //making row zero
        for(int k=0; k<c; k++) m[i][k] = -1;

        //making col zero
        for(int k=0; k<r; k++) m[k][j] = -1;
    }
    public static void main(String[] args) {
//        Given an ‘N’ x ‘M’ integer matrix, if an element is 0, set its entire row and column to 0's, and return the matrix. In particular, your task is to modify it in such a way that if a cell has a value 0 (matrix[i][j] == 0), then all the cells of the ith row and jth column should be changed to 0.
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
            for(int j=0; j<n; j++)
            {
                if(mtx[i][j] == 0){
                    setZero(mtx, i, j);
                }
            }
        }
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(mtx[i][j] == -1){
                    mtx[i][j] = 0;
                }
            }
        }

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                System.out.print(mtx[i][j] + " ");
            }
            System.out.println();
        }


    }
}
