public abstract class reversenumber {
    public static void main(String[] args) {
        int n = 10400;
        while(n % 10 == 0){
            n/= 10;
        }
        int reverse = 0;
        while(n > 0){
            int lastdigit = n%10;
            reverse = reverse*10+lastdigit;
            n /= 10;
        }
        System.out.println(reverse);
    }
}
