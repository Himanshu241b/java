import java.util.*;

class SumMatrixZeroes {
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        System.out.println("Enter rows in matrix: ");
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
                    count += findCoverage(matrix, i, j);
        System.out.println("coverage:"+count);
    }
    public static int findCoverage(int[][] matrix, int i, int j){
        int val = 0;
        if(i-1 < 0){}
        else if(matrix[i-1][j] == 1)
            ++val;
        if(i+1 == matrix.length){}
        else if(matrix[i+1][j] == 1)
            ++val;
        if(j-1 < 0){}
        else if(matrix[i][j-1] == 1)
            ++val;
        if(j+1 == matrix[0].length){}
        else if(matrix[i][j+1] == 1)
            ++val;
        return val;
        }   
}