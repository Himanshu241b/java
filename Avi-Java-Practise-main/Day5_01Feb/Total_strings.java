package Day5_01Feb;

import java.util.Scanner;

public class Total_strings {

    public static int solve(int n, int i, int countb, int countc)
    {
        //base case
        if(i >= n) return 1;

        int count = 0;

        count += solve(n, i+1, countb, countc);

        if(countb < 1) count += solve(n, i+1, countb+1, countc);

        if(countc < 2) count += solve(n, i+1, countb, countc+1);

        return count;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n = sc.nextInt();
        int count = 0;
        System.out.println(solve(n, 0, 0, 0));

    }
}
