//question 13

import java.util.Scanner;

public class searchinsertposition {
    public static void main(String args[]) {
         Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the size of array");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the ELEMENTS");
        for (int i = 0; i < n; i++) 
            arr[i] = scanner.nextInt();
        System.out.println("Enter target element");
        int target = scanner.nextInt();
        int result = searchInsert(arr, target);
        System.out.println("Position:"+result);
    }
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return left;
    }
}
