import java.util.Scanner;
import java.util.Arrays;
public class first {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = 6;
        System.out.println("Enter number of elements");
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter array elements");
        for(int i = 0; i < n; i++)
            array[i] = sc.nextInt();
        tripletSum(array, target);
        
    }
    public static void tripletSum(int[] nums, int target) {

        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++){
            if(i -1 >=0 && nums[i-1] == nums[i])
                continue;
            int j =i+1;
            int  k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==target){
                    System.out.println("["+nums[i]+","+nums[j++]+","+nums[k--]+"]");
                    while( nums[j-1] == nums[j])
                    ++j;
                }
                else if (sum >target) k--;
                else j++;
            }

        }
        
    }
    }

