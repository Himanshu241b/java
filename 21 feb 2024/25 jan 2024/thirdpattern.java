public class thirdpattern {
    public static void main(String[] args){
        int n = 4;
        int count = 0;
        for(int k = 0; k < n; ++k){
            int t = 65+k;
            for(int i = 65+k; i <= 65+k+count; ++i){
                System.out.print((char)t);
            }
        ++count;
        System.out.println();
    }
}
}