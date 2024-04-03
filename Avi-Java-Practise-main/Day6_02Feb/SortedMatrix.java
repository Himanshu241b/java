package Day6_02Feb;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SortedMatrix {
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

        ArrayList<Integer> arr = new ArrayList<>();

        //(a, b) -> a[0] - b[0]: This lambda expression takes two arrays a and b as parameters and compares their first elements (a[0] and b[0]). The subtraction a[0] - b[0] is used to determine the ordering. If the result is negative, it means a[0] is smaller, and if it's positive, it means a[0] is larger. If the result is zero, it means the elements are considered equal.
        PriorityQueue<int[]> p = new PriorityQueue<>((a, b)  -> a[0]-b[0]);

        //insert rows first elements in min heap
        for(int i=0; i<mtx.length; i++) p.offer(new int[]{mtx[i][0], i, 0});

        while(!p.isEmpty())
        {
            int[] curr = p.poll();
            int value = curr[0];
            int row = curr[1];
            int col = curr[2];

            arr.add(value);

            if(col+1 < m){
                p.offer(new int[]{mtx[row][col+1], row, col+1});
            }
        }

        for(int i:arr) System.out.print(i + " ");



    }
}
