import java.util.Scanner;

public class FirstMissingPositive {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int size = scanner.nextInt();
        int nums[] = new int[size];
        System.out.println("Enter elements of array:");
        for (int i = 0; i < size; i++){
            nums[i] = scanner.nextInt();
        }
        System.out.println("First missing positive:");
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        // cycle sort
        int i = 0;

        while(i < nums.length){
            int correct = nums[i] - 1;
            if(nums[i] < nums.length && nums[i] > 0 && nums[i] != nums[correct]){
                // swap the two numbers
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }
            else
                ++i;
        }

        // now the list is sorted so find missing number
        for(int j = 0; j < nums.length; ++j){
            if(nums[j] != j+1)
                return j+1;
        }

        //when every number is present in the array the number must be nums.length+1
        return nums.length+1;
    }
}
