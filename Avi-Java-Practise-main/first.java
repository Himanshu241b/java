import java.util.*;
public class first {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n ");
        int n = 5;
//        1.
//        for(int i=1; i<=n; i++)
//        {
//            for(int j=1; j<=i; j++) System.out.print(j + " ");
//            System.out.println();
//        }

//        2.

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

//        3.
//        for(int i=1; i<=n; i++)
//        {
//            for(int j=1; j<=n-i+1; j++) System.out.print(n-i+1+" ");
//            System.out.println();
//        }

//        4.
        int count = 1;
        for(int i=1; i<=n; i++)
        {

            for(int j=1; j<=i; j++){
                if(count == 10) count = 0;
                System.out.print(count++);
            }
            System.out.println();
        }



    }


}


//4444
//333
//22
//1
//
//
//1
//12
//123
//1234
//
//1
//23
//456
//7891p0