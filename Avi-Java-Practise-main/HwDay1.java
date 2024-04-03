import java.util.Scanner;

public class HwDay1 {

    //function :
    static boolean checkPalindrome(int n)
    {
        int temp = n;
        int ans = 0;
        while(temp > 0)
        {
            int digit = temp%10;
            ans = ans*10 + digit;
            temp /=10;
        }
        if(n == ans) return true;
        else return false;
    }

    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);

//        1. Given a decimal number (integer N), convert it into binary and print.
//        int n = sc.nextInt();
//        String ans = "";
//
//        while(n > 0)
//        {
//            if(n%2 == 0) ans = "0" + ans;
//            else ans = "1" + ans;
//            n /= 2;
//        }
//        for(int i=0; i<ans.length(); i++)
//            System.out.print(ans.charAt(i));


//        2. Given an integer N, print all the prime numbers that lie in the range 2 to N (both inclusive).
//        Print the prime numbers in different lines.
//        int n = sc.nextInt();
//        boolean isPrime = true;
//        for(int i=2; i<=n; i++)
//        {
//            isPrime = true;
//            for(int j=2; j<i/2; j++)
//            {
//                if(i%j == 0) isPrime = false;
//            }
//            if(isPrime) System.out.print(i + " ");
//        }


        //Pattern 1
//        int n = sc.nextInt();
//        int count = 0;
//        int dcount = 0;
//        for(int i=1; i<=n; i++)
//        {
//            for(int j=n-i+2; j>0; j--) System.out.print(" ");
//            count = i;
//            for(int j=1; j<=2*i-1; j++)
//            {
//                if(j > (2*i-1)/2) System.out.print(count--);
//                else System.out.print(count++);
//            }
//            System.out.println();
//        }

//        Pattern 2
//        int n = sc.nextInt();
//        int hf = n/2;
//        int nhf = 1;
//        for(int i=1; i<=n; i++)
//        {
//
//
//            if(i > (n/2)+1)
//            {
//                for(int j=1; j<=nhf; j++) System.out.print(" ");
//                for(int j=1; j<=2*(n-i+1)-1; j++) System.out.print("*");
//                nhf++;
//
//            }
//            else
//            {
//
//                for(int j=1; j<=hf; j++) System.out.print(" ");
//                for(int j=1; j<=2*i-1; j++) System.out.print("*");
//                hf--;
//            }
//
//            System.out.println();
//        }


        //5. Write a program to print triangle of user defined integers sum.
//        int n = sc.nextInt();
//        int sum = 0;
//        for(int i=1; i<=n; i++)
//        {
//            for(int j=1; j<=i; j++)
//            {
//                sum += j;
//                if(j < i) {
//                    System.out.print(j + "+");
//                }
//                else{
//                    System.out.print(j + "=" + sum);
//                }
//            }
//            sum = 0;
//            System.out.println();
//        }


//        6. Check whether a given number ’n’ is a palindrome number.
//        int n = sc.nextInt();
//
//        System.out.print(checkPalindrome(n));


//        7. Pattern 3
        int n = sc.nextInt();
        for(int i=1; i<=n; i++)
        {
            for(int j=n; j>=1; j--)
            {
                if(j == i) System.out.print("*");
                else System.out.print(j);
            }
            System.out.println();
        }


    }
}
