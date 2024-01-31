import java.util.Scanner;


public class sum_product {
    public static void main(String[] args) { 
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the range");
    int range = sc.nextInt();
    System.out.println("Enter your choice");
    int choice = sc.nextInt();
    switch (choice) {
        case 1 :
            printSum(range);
            break;
        case 2 :
            printProduct(range);
            break;
        default:
            System.out.println("Enter a valid choice");
    }
}
    public  static void printSum(int range){
        int sum = 0;
        for (int i = 1; i <= range; i++) 
            sum+=i;

    System.out.println("sum = " + sum);
}
    public static void printProduct(int range){
        int prod = 1;
        for (int i = 2; i <= range; i++)
            prod*= i;
        System.out.println("prod = " + prod);
    }
}

