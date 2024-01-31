import java.util.Arrays;
import java.util.Scanner;

public class second {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Enter array elements");
        for(int i = 0; i < n;++i)
            array[i] = scanner.nextInt();
        int res = uniqueSize(array);
        System.out.println("size: " + res);
    }
    public static int uniqueSize(int[] array){
        if(array.length == 0)
            return 0;
        int size = 1;
        Arrays.sort(array);
        for(int i=1; i<array.length; i++){
            if(array[i] == array[i-1])
                continue;
            else
                ++size;
        }
        return size;
        
    }
}

