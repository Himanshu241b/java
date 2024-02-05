import java.util.*;
public class sumOfArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of array");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Enter elements of array");
        for(int i= 0; i < n; ++i)
            array[i] = scanner.nextInt();
        System.out.println("Sum:"+sumArray(array, 0, array.length));
    }
    public static int sumArray(int[] array, int i, int n){
        if(i == n)
            return 0;
        return sumArray(array,i+1, n)+array[i];
    }
}
