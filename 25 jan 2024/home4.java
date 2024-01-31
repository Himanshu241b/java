public class home4 {
    public static void main(String[] args) {
        int rows = 7;
        int n = rows/2 +1;

        for(int i = 1; i <= n; i++) { // for each row of upper odd half
            //for spaces
            for(int j = 1; j <= n-i; j++) 
                System.out.print(" ");
            //for stars
            for(int j = 1; j <=2*i-1; ++j)
                System.out.print("*");
            //change the line
            System.out.println();
        }
        // for lower even half 
        for(int i = n-1; i >=1; i--){
            //for spaces
            for(int j = 1; j <= n-i; j++)
                System.out.print(" ");
            // for stars
            for(int j = 1; j <= 2*i-1; j++)
                System.out.print("*");
            // change the line
            System.out.println();
        }
    }
}
