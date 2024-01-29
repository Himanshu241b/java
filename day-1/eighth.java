import java.util.Scanner;

public class eighth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        int start = 1;

        for (int i = 1; i <= rows; i++) {
            int num = start;
            for (int j = 1; j <= rows; j++) {
                System.out.print(num);
                num = (num + 2) % (2 * rows);
           
        }
            System.out.println();
           
            start = (start + 2) % (2 * rows);

            scanner.close();
        }
    }
}
        
