import java.util.*;
public class sortMatrix {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        PriorityQueue<Integer> queue =new PriorityQueue<Integer>();
        System.out.println("Enter rows in matrix: ");
        int rows = sc.nextInt();
        System.out.println("Enter columns in matrix: ");
        int columns = sc.nextInt();
        int[][] matrix = new int[rows][columns];
        System.out.println("Enter array elements");
        List<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < columns; j++){
                matrix[i][j] = sc.nextInt();
                queue.add(matrix[i][j]);
        }
        while(!queue.isEmpty())
            ans.add(queue.poll());
        for(int i = 0; i < ans.size(); i++)
            System.out.print(" "+ans.get(i));
    }
}
