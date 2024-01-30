//question 15
import java.util.HashMap;
import java.util.Scanner;
class targetsumways {
    static HashMap<String, Integer> map= new HashMap<String, Integer>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the size of array");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the ELEMENTS");
        for (int i = 0; i < n; i++) 
            arr[i] = scanner.nextInt();
        System.out.println("Enter the target value");
        int  target = scanner.nextInt();
        int ways = helper(arr, target, 0, 0);
        System.out.println("ways: " + ways);
    }
    public static int helper(int[] nums,int target, int index, int sum){
        // if we reach string length and target equals sum return 1 as it add up a way 
        if(index == nums.length && target == sum)
            return 1;
        // if we reach string length and target doesn't equals sum return 0 as it does not add up a way
        if(index == nums.length && target != sum)
            return 0;
        
        // using immutability property of string to add sum index pair to map
        // using string to store a pair as map key
        String key = sum + "$" + index;
        if(map.containsKey(key))
            return map.get(key);
        
        int count = 0;
        // helper returns for once when value at index is added and once when subtracted and then both added together 
        count = helper(nums, target, index+1, sum+nums[index]) + helper(nums, target, index+1, sum-nums[index]);

        // put the returned count for the key in map for memoization
        map.put(key, count);

        return count;
    }
}