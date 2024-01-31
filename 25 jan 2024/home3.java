public class home3 {
    public static void main(String[] args){
        int rows = 5;

        for(int i = 1; i <= rows; i++){ // for each row
            // loop one for spaces
            for(int j = 1; j <= rows-i; j++)
                System.out.print(" ");
            //second loop to print numbers in increasing order
            for(int j = i; j <= 2*i-1; j++)
                System.out.print(j);
            //third loop to print numbers in decreasing order
            for(int j = 2*i-2; j >= i; --j)
                System.out.print(j);

            // change the line after one row
            System.out.println();
        }
    }
}
