package March_20;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubarraysWithSum_K {
    static int findSubArraySum(int arr[], int n, int k)
    {
        // code here
        Map<Integer, Integer> m = new HashMap<>();
        int sum = 0;
        int countSubs = 0;
        m.put(0, 1);

        for(int i=0; i<n; i++)
        {
            sum += arr[i];

            //if map contains the sum-k, then we need to increment count by its frequency
            if(m.containsKey(sum - k) || sum == k)
            {
                countSubs += m.getOrDefault(sum - k, 0);
            }
            m.put(sum, m.getOrDefault(sum, 0) + 1);
        }
        return countSubs;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {10, -2, 2, -20, 10};
        System.out.println("Enter the value of k");
        int k = sc.nextInt();
        System.out.println(findSubArraySum(arr, arr.length, k));

    }
}
