import java.io.*;
import java.util.*;
import java.lang.*;

public class day1 {
    public static void main(String[]args){

        Scanner sc = new Scanner(System.in);

        //1. find unique chars
//        String s = "abcbowienrrruurriiirruvvhhhdd";
//        String ans = "";
//
//        Map<Character, Integer> count = new HashMap<>();
//
//        for(int i=0; i<s.length(); i++)
//        {
//            char ch = s.charAt(i);
//
//            if(count.containsKey(ch)) count.put(ch, count.get(ch)+1);
//            else count.put(ch, 1);
//        }
//        for(Map.Entry<Character,Integer> i : count.entrySet())
//        {
//            if(i.getValue() == 1) ans += i.getKey();
//        }
//        for(int i=0; i<ans.length(); i++)
//        {
//            System.out.print(ans.charAt(i));
//        }


        //2. Given three values - Start Fahrenheit Value (S), End Fahrenheit value (E) and Step Size (W), you need to convert all Fahrenheit values from Start to End at the gap of W, into their corresponding Celsius values and print the table.



        //3.Write a program to input an integer 'n' and print the sum of all its even digits and the sum of all its odd digits separately.
//        int n = sc.nextInt();
//        int oddSum = 0, evenSum = 0;
//        while(n > 0)
//        {
//            int digit = n%10;
//            if(digit %2 == 0) evenSum += digit;
//            else oddSum += digit;
//            n /= 10;
//        }
//        System.out.print(evenSum + " " + oddSum);


//        4. Write a program that takes a number as input and prints all its factors except 1 and the number itself.. If the number has only two factors (1 and the number itself), then the program should print -1.

//        int n = sc.nextInt();
//        boolean isFactor = false;
//        for(int i=2; i<n; i++)
//        {
//            if(n % i == 0){
//                isFactor = true;
//                System.out.print(i + " ");
//            }
//        }
//        if(!isFactor) System.out.print(-1);


//        5. .Write a program to find x to the power n (i.e. x^n). Take x and n from the user. You need to print the answer.

//        int x = sc.nextInt();
//        int y = sc.nextInt();
//        int ans = 1;
//        for(int i=1; i<=y; i++)
//        {
//            ans *= x;
//        }
//        System.out.println(ans);
//        System.out.print(Math.pow(x, y));


//        6. .Write a program to generate the reverse of a given number N. Print the corresponding reverse number.

//        int n = sc.nextInt();
//        int ans = 0;
//        while(n > 0)
//        {
//            int digit = n%10;
//            ans = ans * 10 + digit;
//            n /=10;
//        }
//        System.out.println(ans);


//        7. pattern1

//        int n = sc.nextInt();
//        int count = 1;
//        for(int i=1; i<=n; i++)
//        {
//            count--;
//            for(int j=1; j<=i; j++)
//            {
//                System.out.print((char)('A' + (count++)));
//            }
//            System.out.println();
//        }


        //8. Pattern 2
//        int n = sc.nextInt();
//        for(int i=1; i<=n;  i++)
//        {
//
//            for(int j=i; j>0; j--)
//            {
//                System.out.print(j);
//            }
//            System.out.println();
//        }


        //9. Pattern 3
//        int n = sc.nextInt();
//        int count = 0;
//        for(int i=1; i<=n; i++)
//        {
//            for(int j=1; j<=i; j++)
//            {
//                System.out.print((char)('A' + (count)));
//            }
//            count++;
//            System.out.println();
//        }

        //10. Pattern 4

//        int n = 5;
//        int count = 0;
//        for(int i=1; i<=n; i++)
//        {
//            count = 5-i;
//            for(int j=1; j<=i; j++)
//            {
//                System.out.print((char)('A' + count++));
//            }
//
//            System.out.println();
//        }

        //Pattern 5
//        int n = sc.nextInt();
//        for(int i=1; i<=n; i++)
//        {
//            for(int j=1; j<=i-1; j++) System.out.print(" ");
//
//            System.out.println("***");
//        }


        //Pattern 6
//        int n = sc.nextInt();
//        for(int i=1; i<=n; i++)
//        {
//            for(int j=1; j<=n-i; j++) System.out.print("  ");
//
//            for(int j=1; j<=2*i-1; j++)
//            {
//                System.out.print(j + " ");
//            }
//            System.out.println();
//        }



        //Pattern 7
//        int n = 4;
//        int it = 1;
//        int prev = 1;
//        for(int i=1; i<=n; i++)
//        {
//            prev = it;
//            for(int j=1; j<=n; j++)
//            {
//                if(prev > 7) prev = 1;
//                System.out.print(prev);
//                prev+=2;
//            }
//            it += 2;
//            System.out.println();
//        }



    }
}
