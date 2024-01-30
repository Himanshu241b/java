import java.util.ArrayList;
import java.util.Scanner;

public class infinitesortedarray01 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter size of array");
        int size = sc.nextInt();
        ArrayList arr = new ArrayList(size);
        System.out.println("enter array elements");
        for(int i = 0;i < size;i++)
            arr.add(sc.nextInt());
        
        int i = 0;
        int j = arr.size() - 1;
        int ans = -1;
        while(i <= j){
            int mid = i +(j-i)/2;
            if(arr.get(i) == (Integer)1){
                ans = mid;
                j = mid-1;
            }
            else if(arr.get(i) == (Integer)0){
                i = mid+1;
            }
            else
                j = mid-1;
        }

        System.out.println("the position of index " + ans);
    }
}
