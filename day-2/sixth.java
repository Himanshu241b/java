import java.util.Scanner;

public class sixth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of 1st array");
        int n = scanner.nextInt();
        System.out.println("Enter the size of 2nd array");
        int m = scanner.nextInt();
        int[] array1 = new int[n];
        int[] array2 = new int[m];
        int sum1 = 0;
        int sum2 = 0;
        System.out.println("Enter array1 elements");
        for(int i = 0; i < n;++i){
            array1[i] = scanner.nextInt();
            sum1 = sum1*10+array1[i];
        }
        System.out.println("Enter array2 elements");
        for(int i = 0; i < m;++i){
            array1[i] = scanner.nextInt();
            sum2 = sum1*10+array2[i];
        }
        int sum3 = sum1 + sum2;
        System.out.println("sum is " + sum3);
        
        
    }
}
