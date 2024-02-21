class parallelogram {
    public static void main(String[] args){
        int n = 4;
        int count = 0;
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= n; ++j){
                System.out.print("*");
            }
            System.out.println();
            for(int k = 0; k <= count; ++k){
                System.out.print(" ");
            }
            ++count;
        }
    }
}