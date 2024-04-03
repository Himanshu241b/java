public class countDigit {
    public static void main(String[]args)
    {
        int n = 1234;
        int ans = 0;
        if(n == 0) ans = 1;

        else {
            while(n != 0)
            {
                int digit = n % 10;
                ans++;
                n /= 10;
            }
        }
        System.out.print(ans);
    }
}
