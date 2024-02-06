import java.util.Scanner;

public class NCR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);   
        System.out.println("Enter N");
        int N = sc.nextInt();
        System.out.println("Enter R");
        int R = sc.nextInt();

        System.out.println(NCr(N, R));
    }

    public static int NCr(int N, int r) {
        if (r == 0 || r == N) { //base case as we have just one way to select from 0 or N elements from N elements
            return 1;
        } else {
            // NCr = (N-1)C(r-1) + (N-1)Cr 
            //formula to calculate NCr
            //it states to include Nth element and choose r-1 from remaining n-1 elements (N-1)Cr-1 + 
            //exclude Nth element and choose r from remaining n-1 elements  i.e (N-1)Cr
            return NCr(N - 1, r - 1) + NCr(N - 1, r);
        }
    }
}
