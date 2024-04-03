package Feb_06;

public class NumberRaisedReverse {
    static long MOD = 1000000007;
    static long powerOfReverse(long N, long R) {
        long result = 1;
        long temp = N;
        // Calculate N^R modulo 10^9+7
        while (R > 1) {
            N = (N * temp) % MOD;
            R--;
        }

        return N;
    }

    static long reverse(long n)
    {
        long rev = 0;
        while(n > 0)
        {
            long digit = n%10;
            rev = rev*10 + digit;
            n /= 10;
        }
        return rev;
    }
    public static void main(String[] args) {

        long n = 57;
        long r = reverse(n);
        System.out.println("Output for N = " + n + ", R = " + r + ": " + powerOfReverse(n, r));

    }
}
