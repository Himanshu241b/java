public class home8 {
    public static void main(String[] args) {
        int rows = 5;
        int track = 1;
        for(int i = 1; i <= rows; ++i){ 
            for(int j = rows; j >= 1; --j){
                if(track == j) 
                    System.out.print("*");
                else    
                    System.out.print(j);
            }
            ++track;    //after each row increment the track
            System.out.println();
        }
    }
}
