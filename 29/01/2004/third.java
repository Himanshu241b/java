import java.util.Scanner;
import java.math.*;
public class third{
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array");
        n=sc.nextInt();
        int sum1=0,sum2=0,sum3=0,sum4=0;
        int [] arr=new int[n];
        System.out.println("Enter elements of array");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            sum1=sum1+arr[i];
            sum3=sum3+(arr[i]*arr[i]);
            sum2=sum2+i;
            sum4=sum4+(i*i);
        }
         sum2=sum2+n;
         sum4=sum4+(n*n);
         
         int x=sum1-sum2;
         int y=sum4-sum3;
         int z=y/x;
         int m=(z+x)/2;
         int r=sum1-sum2+m;
         System.out.println("Missing value="+Math.abs(m)+",and repeative value="+Math.abs(r));

    }
}