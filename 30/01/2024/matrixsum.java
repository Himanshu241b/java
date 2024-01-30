import java.util.Scanner;
public class matrixsum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter matrix dimension");
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        System.out.println("enter matrix elements");
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int sum = 0;
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                if(i == 0 || j == 0 || i == n-1 || j == n-1){
                    sum+=matrix[i][j];
                    matrix[i][j] = 0;
               }
    int i = 1;
    while(i < n-1){
        sum += matrix[i][i];
        matrix[i][i] = 0;
        ++i;
        
    }
    i = 1;
    int j = n-2;
    while(i < n-1 && j >0){
        sum+= matrix[i++][j--];
    }

    
    System.out.println("sum = " + sum);
    }
}
