public class seventh {
    public static void main(String[] args) {
        int rows = 3;
        
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= rows - i; ++j) { // prints the spaces at start
                System.out.print(" ");
            }
            for(int j = 1; j <= i; ++j){  // prints the numbers
                System.out.print(j);
            }
            System.out.println(); // shifts the line
            
        }
    }
}
