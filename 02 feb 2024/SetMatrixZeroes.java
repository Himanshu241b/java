import java.util.*;


public class SetMatrixZeroes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> zeroes = new HashMap<Integer, Integer>();
        System.out.println("Enter rows in matrix: ");
        int rows = sc.nextInt();
        System.out.println("Enter columns in matrix: ");
        int columns = sc.nextInt();
        int[][] matrix = new int[rows][columns];
        System.out.println("Enter array elements");
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < columns; j++)
                matrix[i][j] = sc.nextInt();
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < columns; j++)
                if(matrix[i][j] == 0)
                    zeroes.put(i,j);
        
        zeroes.forEach((k, v)->{
            
            
            // for column
            for(int i = 0; i < rows; ++i)
            matrix[i][v] = 0;
            //for row
            for(int i = 0; i < columns; ++i)
            matrix[k][i] = 0;
        
        });
        
        // print array
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < columns; ++j)
                System.out.print(" " + matrix[i][j]);
            System.out.println();
        }

    }
}
