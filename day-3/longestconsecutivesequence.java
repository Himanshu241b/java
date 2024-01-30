import java.util.Arrays;
import java.util.Scanner;
public class longestconsecutivesequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements: ");
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        int maxlength = 1;
        int curlength = 1;
        for(int i = 1; i<arr.length; ++i){
            if(arr[i] - arr[i-1] == 1)
                ++curlength;
            else if(arr[i] != arr[i-1])
                curlength = 1;
            if(maxlength < curlength)
                maxlength = curlength;
        }
        System.out.println("Longest consecutive length is " + maxlength);
        
    }
}
