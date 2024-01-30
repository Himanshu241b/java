//question2
import java.util.Scanner;

public class firstandlast {
    public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the size of array");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the ELEMENTS");
        for (int i = 0; i < n; i++) 
            arr[i] = scanner.nextInt();
        System.out.println("enter the target");
        int target = scanner.nextInt();
        int first = first(arr, target);
        int last = last(arr, target);
        System.out.println("first: " + first + " last: " + last);
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
