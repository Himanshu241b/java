//imports
import java.util.Scanner;
class ArrayProductExceptSelf{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int size = sc.nextInt();
        int[] array = new int[size];
        System.out.println("Enter "+size+"array elements:");
        for(int i = 0;i < size;i++)
            array[i] = sc.nextInt();
        int [] res = findResultArray(array);
        for(int i = 0;i < size; ++i)
            System.out.println(res[i]);
    }

        public static int[] findResultArray(int[] nums) {
            int ans[] = new int[nums.length];
            int temp =1;
            for(int i =0 ; i< nums.length; ++i){
                ans[i] = temp;
                temp *= nums[i];
            }
            temp = 1;
            for(int i = nums.length-1; i>=0; --i){
                ans[i] *= temp;
                temp *= nums[i];
            }
            return ans;
        }
    }
