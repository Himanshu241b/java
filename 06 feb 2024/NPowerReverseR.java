import java.util.Scanner;
public class NPowerReverseR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n");
        int n = scanner.nextInt();
        System.out.println("Enter r");
        int r = scanner.nextInt();
        System.out.println(findPowerMod(n, r));


    }

    public static long findPowerMod(int N, int R) {
        int MOD = 1000000007;
        long result = 1;

        // Calculate reverse of R
        int reverseR = 0;
        while (R > 0) {
            int digit = R % 10;
            reverseR = reverseR * 10 + digit;
            R /= 10;
        }

        // Compute N^R % MOD using modular exponentiation
        while (reverseR > 0) {
            if (reverseR % 2 == 1) {
                result = (result * N) % MOD;
            }
            N = (N * N) % MOD;
            reverseR /= 2;
        }

        return result;
    }
}
