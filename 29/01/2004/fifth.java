import java.util.Scanner;
class fifth{
    public static void main(String[] args) {
        System.out.println("Enter size of array");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Enter first element index for range");
        int ind1 = scanner.nextInt();
        System.out.println("Enter second element index for range");
        int ind2 = scanner.nextInt();
        int range = ind2-ind1 +1;
        int sum = 0;
        int i = ind1, t = 0;
        while(t++ < range){
            sum += arr[i%arr.length];
            ++i;
        }
       
        System.out.println("Sum = " + sum);
    }
}