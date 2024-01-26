import java.util.*;

public class home2 {
    public static void main(String[] args){
        int n = 16;
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr, true);

        for(int p = 2; p * p <= n; ++p){
            if(arr[p])
                for(int j = p*p; j <= n; j+=p)
                    arr[j] = false;
        }

        for(int i = 2; i <= n; ++i){
            if(arr[i])
                System.out.println(i);
        }
}
}
