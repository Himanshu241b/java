import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class arrayoccurancein2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements in array");
        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] array = new int[n];

        System.out.println("Enter elements of array");
        for(int i = 0; i <n; i++) {
            array[i] = sc.nextInt();
        }
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum^= array[i];
    }
    System.out.println("unique: " + sum);
}
}
