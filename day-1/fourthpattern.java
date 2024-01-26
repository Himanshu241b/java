public class fourthpattern {
    public static void main(String[] args) {
        int n = 5;
        int count = 0;
        for(int k = n-1; k >=0; --k){
            for(int i = 65+k; i <= 65+k+count; ++i){
                System.out.print((char)i);
            }
        ++count;
        System.out.println();
    }
}
}
