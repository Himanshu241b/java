import java .util.*;

public class DiagonalPrint {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows in matrix: ");
        int n = sc.nextInt();
       
    
        int[][] matrix = new int[n][n];
        System.out.println("Enter array elements");
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        int j = 0;
        for(int t = 0; t < n; t++){
            for(int i = 0; i < n-t; ++i){
                System.out.print(" "+ matrix[i][j++]);
            }
            System.out.println();
            j = t+1;
        }
    }
}
