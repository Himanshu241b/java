import java.util.PriorityQueue;
import java.util.Scanner;
public class seventh {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b)->(b-a));
        System.out.println("Enter number of elements");
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter array elements");
        for(int i = 0; i < n; i++)
            array[i] = sc.nextInt();
        System.out.println("Enter the value of k");
        int k = sc.nextInt();
        for(int i = 0; i < n; i++)
            queue.add(array[i]);
        System.out.println(k+"largest elements are");
        for(int i = 0; i < k; ++i)
            System.out.println(queue.poll());
    }
    
}
