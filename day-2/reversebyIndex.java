import java.util.Scanner;


public class reversebyIndex {
    public static void main(String[] args) {
        System.out.println("Enter size of array");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elemets");
        for(int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
    }
    System.out.println("Enter index from where to reverse");
    int r = sc.nextInt();
    int[] res = reverseArray(r+1, n-1, array);
    for(int i = 0; i < n; i++){
        System.out.print(res[i]+" ");
    }
}
    public static int[] reverseArray(int r, int n, int[] array) {
        if(r == n+1)
            return array;
        else{
            while(r < n){
                int temp = array[r];
                array[r] = array[n];
                array[n] = temp;
                r++;
                --n;
            }
            return array;
        }
    }
        
}
