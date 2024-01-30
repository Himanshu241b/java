public class countDigits {
    public static void main(String[] args) {
        int n = 0;
        System.out.println(getCount(n));
        
    }
    public static int getCount(int n){
        int count = 0;
        n = Math.abs(n); // to handle negative test cases
            while(n > 0){
                ++count;
                n /= 10;
            }
        return count;
    }
}
