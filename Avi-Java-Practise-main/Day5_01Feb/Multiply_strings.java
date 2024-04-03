package Day5_01Feb;

import java.util.Scanner;

public class Multiply_strings {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first string");
        String s1 = sc.nextLine();

        System.out.println("Enter the 2nd string");
        String s2 = sc.nextLine();

        int[] res = new int[s1.length()+s2.length()];


        for(int i=s1.length()-1; i>=0; i--)
        {
            for(int j=s2.length()-1; j>=0; j--)
            {
                int prod = (s1.charAt(i)-'0') * (s2.charAt(j)-'0');
                int sum = prod + res[i+j+1];
                res[i+j] += sum/10;
                res[i+j+1] = sum%10;
            }
        }

        StringBuilder ans = new StringBuilder();
        for(int i: res){
            if(!(ans.isEmpty() && i == 0)) ans.append(i);
        }

        System.out.println(ans);

    }
}
