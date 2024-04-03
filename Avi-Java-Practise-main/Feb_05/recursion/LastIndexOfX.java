package Feb_05.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class LastIndexOfX {

    static int solve(ArrayList<Integer> arr, int x, int i, int ans)
    {
        //base  case
        if(i >= arr.size()) return ans;

        if(arr.get(i) == x) ans = i;
        return solve(arr, x, i+1, ans);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> arr = new ArrayList<Integer>();

        System.out.println("Enter the array size value");
        int n = sc.nextInt();


        System.out.println("Enter the elements of array");
        for (int i = 1; i <= n; i++) {
            int el = sc.nextInt();
            arr.add(el);
        }

        System.out.println("Enter value of x");
        int x = sc.nextInt();
        int ans = 0;
        System.out.println(solve(arr, x, 0, ans));
    }
}
