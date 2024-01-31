//question 1
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class numberofoccurance {
    public static void main(String[] args){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b)->(b-a));
        System.out.println("Enter number of elements");
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter array elements");
        for(int i = 0; i < n; i++)
            array[i] = sc.nextInt();
        System.out.println("Enter x:");
        int x = sc.nextInt();
        int first = first(array, x);
        int last = last(array, x);
        System.out.println("Number of occurrences: "+(last-first+1));
        
}
public static int first(int[] nums, int target){
    int low = 0;
    int high = nums.length-1;
    int ans = -1;
    while(low <= high){
        int mid = low + (high - low)/2;
        if(nums[mid] == target){
            ans = mid;
            high = mid-1;
        }
        else if(nums[mid] > target)
            high = mid - 1;
        else
            low = mid + 1;
    }
    return ans;
}
public static int last(int[] nums, int target){
     int low = 0;
    int high = nums.length-1;
    int ans = -1;
    while(low <= high){
        int mid = low + (high - low)/2;
        if(nums[mid] == target){
            ans = mid;
            low = mid+1;
        }
        else if(nums[mid] > target)
            high = mid - 1;
        else
            low = mid + 1;
    }
    return ans;
}
}
