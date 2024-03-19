import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PairsWithDifferenceK {
    public static void main(String[] args){
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
        System.out.println(countKDifference(nums, 1));
    }
    public static int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int num : nums){
            res += map.getOrDefault(num-k, 0) + map.getOrDefault(num+k, 0);
            map.put(num, map.getOrDefault(num,0)+1);
        }
        return res;
    }
}
