import java.util.Scanner;

public class sort012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the ELEMENTS");
        for (int i = 0; i < n; i++) 
            arr[i] = scanner.nextInt();
        int i = 0;
        int j = 0;
        int k = arr.length-1;
        while(i < k){
            if(arr[i] == 0){
                swap(arr,i,j);
                ++j;
                ++i;
            }
            else if(arr[i] == 1)
                ++i;
            else{
                swap(arr, i, k);
                --k;
            }
        }
        for(int t = 0; t <n; t++)
            System.out.println(" "+arr[t]);
        
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
