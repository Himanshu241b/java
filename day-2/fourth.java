import java.util.Scanner;

public class fourth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Enter array elements");
        for(int i = 0; i < n;++i)
            array[i] = scanner.nextInt();
        int prod = 1;
        for(int i = 0; i < n;++i)
            prod*=array[i];
        for(int j = 0; j < n;++j){
            System.out.print(prod/array[j]+" ");
        }
    }
}
