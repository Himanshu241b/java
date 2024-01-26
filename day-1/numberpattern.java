public class numberpattern {
    public static void main(String[] args){
        int n = 4;
        int count = 0;
        for(int k = 1; k <= n; ++k){
            for(int i = k; i <= k+count; ++i){
                System.out.print(i);
            }
            ++count;
        System.out.println();
        }
    }
}
