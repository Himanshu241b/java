package Feb_05;

import java.util.*;

public class BinarySum {
    //You have been given two binary strings ‘A’ and ‘B’. Your task is to find the sum of both strings in the form of a binary string.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first binary string");
        String str1 = sc.next();
        int n1 = str1.length();

        System.out.println("Enter the 2nd binary string");
        String str2 = sc.next();
        int n2 = str2.length();

        StringBuilder res = new StringBuilder();

        int i=n1-1, j=n2-1;
        int carry = 0;

        while(i >= 0 && j >=  0)
        {
            char ch1 = str1.charAt(i--);
            char ch2 = str2.charAt(j--);

            if((ch1 == '1' && ch2 == '0') || (ch1 == '0' && ch2 == '1') ) res.append('1');

            else if((ch1 == '1' && ch2 == '1')) {
                if (carry == 1) res.append('1');
                else res.append('0');
                carry = 1;
            }
        }
//        while(i >= 0)
//        {
//
//        }
//        while(j >= 0)
//        {
//
//        }
        System.out.println(res);
    }


}
