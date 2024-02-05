import java.util.Scanner;

public class towerOfHanoi {
    
    public static void towerOfHanoi(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            System.out.println(source + " " + destination);
            return;
        }
        
        towerOfHanoi(n - 1, source, destination, auxiliary);
        System.out.println(source + " " + destination);
        towerOfHanoi(n - 1, auxiliary, source, destination);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of disks: ");
        int n = scanner.nextInt();
        scanner.close();
        
        System.out.println("Steps to move " + n + " disks from source rod 'a' to destination rod 'c':");
        towerOfHanoi(n, 'a', 'b', 'c');
    }
}
