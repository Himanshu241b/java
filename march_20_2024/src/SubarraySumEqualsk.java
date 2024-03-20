import java.util.HashMap;
import java.util.Scanner;

public class SubarraySumEqualsk {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int size = scanner.nextInt();
        int nums[] = new int[size];
        System.out.println("Enter elements of array:");
        for (int i = 0; i < size; i++){
            nums[i] = scanner.nextInt();
        }
        System.out.println("Enter value of k:");
        int k = scanner.nextInt();
        System.out.println("count of subarrays with sum k:");
        System.out.println(subarraySum(nums, k));
    }
    public static int subarraySum(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1); // identity element
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length;++i){
            sum += nums[i];
            int rem = sum - k;
            if(map.containsKey(rem)){
                count += map.get(rem);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
