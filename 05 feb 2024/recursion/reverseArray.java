import java.util.Scanner;
import java.util.Stack;

public class reverseArray {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter elements of array");
        for(int i= 0; i < n; ++i)
            array[i] = sc.nextInt();
        reverseStack(array, 0, array.length-1 );
        for(int i=0; i < n; ++i)
            System.out.print(" "+array[i]);
    }
    public static void reverseStack(int[] array, int i, int j){
        if(i < j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        reverseStack(array, i+1,j-1);
        }

        

    }
}
