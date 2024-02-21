public class characterpattern {
    public static void main(String[] args) {
        int n = 4;
        int count = 0;
        for(int k = 0; k < n; ++k){
            for(int i = 65+k; i <= 65+k+count; ++i){
                System.out.print((char)i);
            }
            ++count;
        System.out.println();
        }
    }
}
