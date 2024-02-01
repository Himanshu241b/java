import java.util.*;
public class totalstrings {
    int bcount = 0;
    int ccount = 0;

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of string");
        int n = sc.nextInt();
        List<String> list = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        int count = countValidStrings(n, 0,0);
        System.out.println(count);
        }
    
        public static int countValidStrings(int N, int bCount, int cCount) {
            // Base case: if N becomes 0, return 1
            if (N == 0) {
                return 1;
            }
            
            // Initialize count of valid strings
            int count = 0;
            
            // If there's less than 2 b we can append b
            if (bCount < 1) {
                count += countValidStrings(N - 1, bCount + 1, cCount);
            }
            // If there's less than 2 c we can append c
            if (cCount < 2) {
                count += countValidStrings(N - 1, bCount, cCount + 1);
            }
            // We can always append a
            count += countValidStrings(N - 1, bCount, cCount);
            
            return count;
        
    }
}
