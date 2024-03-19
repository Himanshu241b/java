import java.util.Scanner;
import java.util.TreeSet;

class LongestSubarrayKDifference{
    public static int longestSubarrayLength(int[] nums, int k) {
        int left = 0;
        int maxSubarrayLength = 1;
        TreeSet<Integer> set = new TreeSet<Integer>((a, b) -> nums[a] == nums[b] ? a-b : nums[a] - nums[b]);
        set.add(0);

        for(int right = 1; right < nums.length; ++right) {
            set.add(right);
            if(nums[set.last()] - nums[set.first()] > k){
                set.remove(left++);
            }
            maxSubarrayLength = Math.max(maxSubarrayLength, right - left + 1);
        }
        return maxSubarrayLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int size = scanner.nextInt();
        int[] nums = new int[size];
        System.out.println("Enter " + size + " elements of array:");
        for(int i = 0; i < size; i++){
            nums[i] = scanner.nextInt();
        }
        System.out.println("Enter value of k:");
        int k = scanner.nextInt();
        System.out.println("Length of the longest subarray: " + longestSubarrayLength(nums, k));
    }
}